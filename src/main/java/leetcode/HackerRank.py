#!/bin/python3

import math
import os
import random
import re
import sys


def extraLongFactorials(n):
    mysum = n
    i = n - 1
    while (i > 1):
        mysum *= i
        i -= 1
    print(mysum)
    return mysum

def appendAndDelete(s, t, k):
    if (s == t or k >= len(s) + len(t)):
        return "Yes"
    i = 0
    while (i < len(s) and i < len(t) and s[i] == t[i]):
        i += 1
    a = len(s) - i
    b = len(t) - i
    if (k < a + b): 
        return "No"
    if (k % 2 != (a + b) % 2):
        return "No"
    return "Yes"

def squares(a, b):
    count = 0
    i = math.ceil(math.sqrt(a))
    square = math.pow(i, 2)
    while (square <= b):
        count += 1
        i += 1
        square = math.pow(i, 2)
    return count

def libraryFine(d1, m1, y1, d2, m2, y2):
    if y1 > y2: return 10000
    if m1 > m2 and y1 == y2: return (m1 - m2) * 500
    if d1 > d2 and y1 == y2 and m1 == m2: return (d1 - d2) * 15
    return 0

def cutTheSticks(arr):
    mylist = []
    arr.sort()
    mylen = len(arr)
    mylist.append(mylen)
    for i in range(0, mylen - 1):
        if (arr[i] == arr[i + 1]): continue
        else: mylist.append(mylen - i - 1)
    return mylist

def nonDivisibleSubset(k, s):
    mods = {}
    for i in s:
        rem = i % k
        mods[rem] = mods[rem] + 1 if rem in mods else 1
    maxlength = 0
    for j in mods:
        if (j == 0 and mods[j] > 0):
            maxlength += 1
        elif (j == k / 2 and mods[j] > 0):
            maxlength += 1
        else:
            comp = k - j
            maxlength += max(mods[j], mods[comp] if comp in mods else 0)
            mods[j] = 0
            if comp in mods: mods[comp] = 0
    return maxlength

def repeatedString(s, n):
    if (n == 0): return 0
    count = 0
    mylist = list()
    for i, val in enumerate(s):
        if val == 'a':
            mylist.append(i)
            
    count += n / len(s) * len(mylist)
    lo = n % len(s)
    for i in mylist:
        if i + 1 <= lo:
            count += 1
        else:
            break
        
    return count

def jumpingOnClouds(c):
    count = 0
    i = 0
    while i < len(c) - 1:
        print(i)
        if i + 2 < len(c) and c[i+2] != 1:
            i += 2
        else:
            i += 1
        count += 1
    return count

def equalizeArray(arr):
    mydict = {}
    for i in arr:
        mydict[i] = mydict.get(i, 0) + 1   
    return len(arr) - max(mydict.values())


arr = [1,2,3,1,2,3,3,3]
print(equalizeArray(arr))
