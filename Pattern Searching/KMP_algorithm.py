def ComputeLPS(pat):
  M = len(pat)
  lps = [0]*M
  i = 0
  j = 1
  while j<M:
    if pat[i] == pat[j]:
      i = i+1
      lps[j] = i
      j = j +1
    else:
      if i != 0:
        i = lps[i-1]
      else:
        lps[j] = 0
        j = j+1
  return lps

def KMPalgorithm(pat, txt):
  P = len(pat)
  T = len(txt)
  lps = ComputeLPS(pat)
  i = 0
  j = 0
  while i<T:
    if pat[j] == txt[i]:
      i+=1
      j+=1
    if j == P:
      print("pattern found in " + str(i-j))
      j = lps[j-1]
    
    elif i < T and pat[j] != txt[i]:
      if j != 0:
        j = lps[j-1]
      else:
        i+=1


print(ComputeLPS("aaabaacd"))
KMPalgorithm("aaabaacd", "aaabaacdwaaabaacd")
