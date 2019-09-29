#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the appendAndDelete function below.
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
# print(appendAndDelete('y', 'yu', 2))


def squares(a, b):
    count = 0
    # for i in range(a, b + 1):
    #     if (math.sqrt(i).is_integer()):
    #         count += 1
    # return count
    i = math.ceil(math.sqrt(a))
    square = math.pow(i, 2)
    while (square <= b):
        count += 1
        i += 1
        square = math.pow(i, 2)
    return count

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
# arr = [1, 13, 3, 8, 14, 9, 4, 4]

arr = [19,10,12,10,24,25,22]
print(nonDivisibleSubset(arr, 4))