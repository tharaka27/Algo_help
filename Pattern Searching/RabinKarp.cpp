#include <iostream>
#include <bits/stdc++.h> 
#include <string>
using namespace std;
/*
Algorithm -  Rabin-Karp algorithm
Writer -  Tharaka Sachintha Ratnayake
Task   -  Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function 
search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. 
You may assume that n > m.
*/

/*
This function calculates the longest prefix which is 
also suffix easily 
*/

int hashFunc(char *str, int q, int d){
  int M = strlen(str);
  int p = 0; 

  for(int i = 0;i < M; i++){
    p =  (d * p + str[i]) % q; 
  }

  return p;
}

void RabinKarp(char *pat, char *txt, int prime,int characters){
  
  int pat_len = strlen(pat);
  int txt_len = strlen(txt);

  int pat_hash = hashFunc(pat,101,256);
  char txt_to_pattern[pat_len];

  for(int k = 0; k < pat_len ; k++){
      txt_to_pattern[k] = txt[k];
  }
  
  int txt_hash = hashFunc(txt_to_pattern, 101, 256);
  int h = 1;
  int i,j;

  for(i = 0; i< pat_len-1 ; i++){
    h = (h * characters) % prime;  
  }


  for(i= 0; i <= txt_len - pat_len; i++){

    if(pat_hash == txt_hash ){
      for(j = 0; j < pat_len; j++){
        if (pat[j] != txt[i + j]){
          break;
        }
      }
      if (j == pat_len){
        cout << "Pattern found @ " << i << endl;
      }
    }
    
   if(i < txt_len - pat_len){
    txt_hash = (characters*(txt_hash - txt[i]*h) + txt[i+ pat_len])% prime;  
  
    // We might get negative value of t, converting it  
    // to positive  
    if (txt_hash < 0)  
      txt_hash = (txt_hash + prime);  

   }

  }
}



int main() {
  char txt[] = "THARAKA SACHINTHA THARAKA BJAHDUANDTHARAKA";  
  char pat[] = "THARAKA";  

  RabinKarp(pat,txt, 101, 256) ;

}
