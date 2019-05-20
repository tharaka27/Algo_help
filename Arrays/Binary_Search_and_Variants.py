import math

arr = [1,2,2,2,3,3,3,3,4,5,5,6,7]

def binary(arr, l,r,x):
  if r >= l :
    mid = math.floor(l+(r-l)/2)

    if arr[mid] == x:
      return mid

    elif arr[mid] > x:
      return binary(arr,l, mid-1, x)
  
    else:
      return binary(arr,mid+1, r, x)
  else:
    return -1


# Naive algorithm will be to use
# for loop. Which will be a 
# O(n) case.

def first(arr, low, high, x):
  ans = -1
  while(low <= high):
    mid = math.floor((low+high)/2)

    if(arr[mid] > x):
      high = mid - 1
    elif(arr[mid] < x ):
      low = mid+1
    elif(arr[mid] == x ):
      ans = mid
      high = mid -1
  return ans

# Naive algorithm will be to use
# for loop. Which will be a 
# O(n) case.

def last(arr, low, high, x):
  ans = -1
  while(low <= high):
    mid = math.floor((low+high)/2)

    if(arr[mid] > x):
      high = mid - 1
    elif(arr[mid] < x ):
      low = mid + 1
    elif(arr[mid] == x ):
      ans = mid
      low = mid +1
  return ans

# Naive algorithm will be to use
# for loop. Which will be a 
# O(n) case.

def greaterthan(arr, low, high, x):
  ans = -1
  while(low <= high):
    mid = math.floor((low+high)/2)

    if(arr[mid] > x):
      ans = mid
      high = mid - 1
    elif(arr[mid] < x ):
      low = mid + 1
    elif(arr[mid] == x ):
      
      low = mid +1
  
  return ans

# Naive algorithm will be to use
# for loop. Which will be a 
# O(n) case.

def lessthan(arr, low, high, x):
  ans = -1
  while(low <= high):
    mid = math.floor((low+high)/2)

    if(arr[mid] > x):
      high = mid - 1

    elif(arr[mid] < x ):
      ans = mid
      low = mid + 1

    elif(arr[mid] == x ):  
      high = mid - 1
  
  return ans

# arr = [1,2,2,2,3,3,3,3,4,5,5,6,7]

print(binary(arr, 0, len(arr),2))
print(last(arr, 0, len(arr),2))
print(first(arr, 0, len(arr),2))
print(lessthan(arr, 0, len(arr),7))
print(greaterthan(arr, 0, len(arr),5))
