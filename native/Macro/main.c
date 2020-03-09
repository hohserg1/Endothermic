#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

#define bool int
#define false 0
#define true 1

typedef void* any;
typedef char* string;

//extendable_array.h
struct _extendable_array{
    any* array;
    int size;
    int chunkSize;
};

typedef struct _extendable_array* extendable_array;

extendable_array newExtendableArray(int initialSize){
    extendable_array r=(extendable_array)malloc(sizeof(struct _extendable_array));
    r->size=0;
    r->array=calloc(initialSize, sizeof(any));
    r->chunkSize=initialSize;
    return r;
}
any get(extendable_array array, int i){
    if(array->size>i)
        return array->array[i];
    else
        return NULL;
}

void set(extendable_array array, int i, any value){
}

void resize(extendable_array array, int size){
    any* prev=array->array;
    array->array=calloc(size, sizeof(any));
    memcpy(array->array,prev,array->size*sizeof(any));
    array->chunkSize=size;
}
void push_back(extendable_array array, any value){
    int pos=array->size;

    if(array->size + 1 >= array->chunkSize)
        resize(array,array->chunkSize*2);

    array->array[pos]=value;
    array->size++;
}

void printArray(extendable_array array){
    for(int i=0;i<array->size;i++)
        printf("%s | ",*(int*)get(array,i));
        printf("\n");
}

void deleteExtendableArray(extendable_array array){
    free(array->array);
    free(array);
}

//macro.h
struct _simple_macro{
    string name;
    string replacement;
};

typedef struct _simple_macro* simple_macro;

struct _complex_macro{
    string name;
    string* args;
    int size;
    string replacement;
};

typedef struct _complex_macro* complex_macro;

complex_macro newMacro(string name,string* args,int size,string replacement){
    complex_macro r=(complex_macro)malloc(sizeof(struct _complex_macro));
    r->name=name;
    r->args=args;
    r->size=size;
    r->replacement=replacement;
    return r;
}

simple_macro newSimpleMacro(string name,string replacement){
    simple_macro r=(simple_macro)malloc(sizeof(struct _simple_macro));
    r->name=name;
    r->replacement=replacement;
    return r;
}

string replace(string line,string name,string replacement){
    int nsize=(strlen(line)/strlen(name)+1)*strlen(replacement);
    string r=calloc(nsize,sizeof(char));
    int ri=0;
    int ni=0;
    for(int i=0;i<strlen(line);i++){
        r[ri]=line[i];
        ri++;
        if(line[i]==name[ni]){
            ni++;
        }
        if(ni==strlen(name)){
            memcpy(r+(ri-ni),replacement,strlen(replacement));
            ri=ri-ni+strlen(replacement);
            ni=0;
        }
    }
    r[ri]='\0';
    return r;
}

string substr(string line,int from,int len){
    string r=calloc(len,sizeof(char));
    memcpy(r,line+from,len);
    r[len]='\0';
    return r;
}

string applyMacro(string line,extendable_array simple_macroses,extendable_array complex_macroses){

    for(int i=0;i<simple_macroses->size;i++){
        simple_macro macro = get(simple_macroses,i);
        line=replace(line,macro->name,macro->replacement);
    }

    for(int i=0;i<complex_macroses->size;i++){
        complex_macro macro = get(complex_macroses,i);

        printf("complex macro %s,%s,",macro->name,macro->replacement);
        for(int i=0;i<macro->size;i++)
            printf("%s,",macro->args[i]);
        printf("\n");

        char* place=strstr(line,macro->name);
        if(place!=NULL){
            char* firstBrace=strchr(place,'(');
            char* secondBrace=strchr(place,')');
            char* forReplace=substr(place,0,secondBrace-place+1);


            printf("%s %d\n",forReplace,secondBrace-place);
            printf("%s\n",line);

            string replacement=calloc(strlen(macro->replacement),sizeof(char));
            memcpy(replacement,macro->replacement,strlen(macro->replacement));

            int argNumber=0;
            string curArg=calloc(secondBrace-firstBrace,sizeof(char));
            int i=0;
            for(char* c=firstBrace+1;c<=secondBrace;c++){
                if(c[0]==',' || c==secondBrace){
                    replacement=replace(replacement,macro->args[argNumber],curArg);
                    argNumber++;
                    curArg=calloc(secondBrace-firstBrace,sizeof(char));
                    i=0;
                }else{
                    curArg[i]=c[0];
                    i++;
                }
            }

            line=replace(line,forReplace,replacement);
        }
    }

    return line;
}

bool startWith(string line, string prefix){
    for(int i=0;i<strlen(prefix);i++){
        if(line[i]!=prefix[i])
            return false;
    }
    return true;
}

void registerMacro(string line,extendable_array simple_macroses,extendable_array complex_macroses){
    //#macro value=expr
    //#macro func(a)expr
    line=strchr(line,' ')+1;
    char* argsStart = strchr(line,'(');
    char* eqStart = strchr(line,'=');
    if(argsStart==NULL){
        int nameLen=eqStart-line;
        int exprLen=strlen(line)-(int)(eqStart-line)-2;
        string name=calloc(nameLen,sizeof(char));
        string expr=calloc(exprLen,sizeof(char));
        memcpy(name,line,nameLen);
        memcpy(expr,eqStart+1,exprLen);
        push_back(simple_macroses,newSimpleMacro(name,expr));
    }else{
        int nameLen=argsStart-line;
        int exprLen=strlen(line)-(int)(eqStart-line)-2;
        string name=calloc(nameLen,sizeof(char));
        string expr=calloc(exprLen,sizeof(char));
        memcpy(name,line,nameLen);
        memcpy(expr,eqStart+1,exprLen);

        char* argsEnd = strchr(line,')');

        extendable_array tempArgs=newExtendableArray(10);
        string curArg=calloc(eqStart-argsStart,sizeof(char));
        int i=0;
        for (char* c=argsStart+1;c<=argsEnd;c++){
            if(c[0]==',' || c==argsEnd){
                push_back(tempArgs,curArg);
                curArg=calloc(argsEnd-argsStart,sizeof(char));
                i=0;
            }else{
                curArg[i]=c[0];
                i++;
            }
        }

        push_back(complex_macroses,newMacro(name,tempArgs->array,tempArgs->size,expr));
    }

}

int main()
{
    setlocale(LC_ALL, "Rus");

    FILE* input = fopen("input.c","r");
    FILE* output = fopen("output.c","w");

    extendable_array simple_macroses=newExtendableArray(10);
    extendable_array complex_macroses=newExtendableArray(10);


    string line=calloc(sizeof(char),256);
    while(fgets(line,255,input)){
        if(startWith(line,"#macro ")){
            registerMacro(line,simple_macroses,complex_macroses);
            fprintf(output,"\n");
        }else{
            line=applyMacro(line,simple_macroses,complex_macroses);
            fprintf(output,line);
        }
    }

    fclose(input);
    fclose(output);

    return 0;
}
