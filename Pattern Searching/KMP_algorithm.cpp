#include <iostream>
#include <bits/stdc++.h> 

using namespace std;
/*

Algorithm -  KMP algorithm
Writer -  Tharaka Sachintha Ratnayake
Task   -  Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function 
search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. 
You may assume that n > m.

*/

/*
This function calculates the longest prefix which is 
also suffix easily 
*/
void compute_lps(char *pat, int *lps){
  int pat_len = strlen(pat);
  lps[0] = 0;
  int i = 0;
  int j = 1;

  while(j < pat_len){
    if(pat[i] == pat[j]){
      i++;
      lps[j] = i;
      j++;
    }
    else{
      if(i == 0){
        lps[j] = 0;
        j++;
      }
      else{

        i = lps[i-1];
      }
    }
  }
}

void KMPSearch(char *txt, char *pat){
  int txt_len = strlen(txt);
  int pat_len = strlen(pat);
  int lps[pat_len];
  compute_lps(pat, lps);

  cout << endl;
  int txt_p = 0;
  int pat_p = 0;

 while(txt_p < txt_len){
  if(pat[pat_p] == txt[txt_p] ){
    pat_p++;
    txt_p++;
  }

  if(pat_p == pat_len){
    cout << "Pattern found @ " << (txt_p-pat_len) << endl;
    pat_p = lps[pat_p -1];
  }

  else if (txt_p < txt_len && pat[pat_p] != txt[txt_p]){
    if( pat_p != 0 ){
      pat_p = lps[pat_p -1];
    }
    else{
      txt_p++;
    }
  } 
 }
}

int main() {
  char txt[] = "AABAABABBABBDBABDBSAAB"; 
  char pat[] = "AAB"; 
  
  KMPSearch(txt, pat);
}
