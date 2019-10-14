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

def queensAttack(n, k, r_q, c_q, obstacles):
    r = r_q
    c = c_q
    count = 0
    #y coordinate is r, x coordinate is c
    b1 = c - r #y intercept for y=x
    b2 = c + r #y intercept for y=-x
    diag_obs1 = []
    diag_obs2 = []
    min_r = 0
    max_r = n + 1
    min_c = 0
    max_c = n + 1
    min_ul = 0
    for i in obstacles:
        if i[0] == r:
            #get all obstacles for the row
            if i[1] > min_r and i[1] < c:
                min_r = i[1]
            elif i[1] < max_r and i[1] > c:
                max_r = i[1]
        elif i[1] == c:
            #get all obstacles for the column
            if i[0] > min_c and i[0] < r:
                min_c = i[0]
            elif i[0] < max_c and i[0] > r:
                max_c = i[0]
        elif i[1] == (i[0] * -1) + b2:
            diag_obs1.append(i)
        elif i[1] == i[0] + b1:
            diag_obs2.append(i)
    
    #go left
    count += c - 1 - min_r
    #go right
    count += max_r - c - 1
    #go up
    count += max_c - r - 1
    #go down
    count += r - min_c - 1
    
#     print("go upleft")
    r1 = r + 1
    c1 = c - 1
    while r1 <= n and c1 > 0:
        if [r1, c1] in diag_obs1:
            diag_obs1.remove([r1, c1])
            break
        count += 1
        r1 += 1
        c1 -= 1

#     print("go upright")
    r1 = r + 1
    c1 = c + 1
    while r1 <= n and c1 <= n:
        if [r1, c1] in diag_obs2:
            diag_obs2.remove([r1, c1])
            break
        count += 1
        r1 += 1
        c1 += 1

#     print("go downleft")
    r1 = r - 1
    c1 = c - 1
    while r1 > 0 and c1 > 0:
        if [r1, c1] in diag_obs2:
            diag_obs2.remove([r1, c1])
            break
        count += 1
        r1 -= 1
        c1 -= 1
     
#     print("go downright")
    r1 = r - 1
    c1 = c + 1
    while r1 > 0 and c1 <= n:
        if [r1, c1] in diag_obs1:
            diag_obs1.remove([r1, c1])
            break
        count += 1
        r1 -= 1
        c1 += 1

    return count


def acmTeam(topic):
    mymax = 0
    count = 0
    for i in range(0, len(topic)):
        for j in range(i + 1, len(topic)):
            x = bin(int(topic[i],2) | int(topic[j],2)).count('1')
            if x > mymax:
                mymax = x
                count = 1
            elif x == mymax:
                count += 1
    return [mymax, count]

def taumBday(b, w, bc, wc, z):
    #cost of gifts are the same
    if (bc == wc): return (b*bc) + (w*wc)
    
    #cost of conversion too high
    elif (z > bc and z > wc): return (b*bc) + (w*wc)
    
    #cost of black too high
    elif (bc > wc + z): return (b*wc) + (b*z) + (w*wc)
    
    #cost of white too high
    elif (wc > bc + z): return (b*bc) + (w*bc) + (w*z)
    
    else: return (b*bc) + (w*wc);

def organizingContainers(container):
    rows = [0] * len(container)
    cols = [0] * len(container)
    for i in range(0, len(container)):
        for j in range(0, len(container)):
            rows[i] += container[i][j]
            cols[j] += container[i][j]
    
    rows.sort()
    cols.sort()

    if rows == cols:
        return 'Possible'
    else:
        return 'Impossible'
    
def encryption(s):
    s = list(s.replace(' ',''))
    l = len(s)
    r = math.floor(math.sqrt(l))
    c = math.ceil(math.sqrt(l))
    new_s = []
    for i in range(c):
        new_s.append([])
    
    if (r * c < l):
        if ((r + 1) * c > r * (c + 1)):
            r += 1
        else:
            c += 1
    
    pos = 0
    for i in range(0, l):
        if (i % c == 0):
            pos = 0
        else:
            pos += 1
        
        new_s[pos].append(s[i])
        
    ans = ''
    for i in new_s:
        ans += "".join(i) + ' '
    
    return ans.rstrip()
    
def beautifulTriplets(d, arr):
    count = 0
    z = [0] * (arr[len(arr) - 1] + 1)
    for i in arr:
        z[i] += 1
    for i in arr:
        if i + (d * 2) < len(z) and z[i + d] > 0 and z[i + (d * 2)] > 0:
            count += z[i + d] * z[i + (d * 2)]
    return count

def biggerIsGreater(w):
    i = len(w) - 1
    while i > 0 and w[i -1] >= w[i]:
        i -= 1
    
    suffix = i
    if suffix == 0: return 'no answer'
    
    pivot = suffix - 1
    swap = pivot
    
    i = len(w) - 1
    while i > swap and w[i] <= w[pivot]:
        i -= 1
    
    swap = i
    
    return w[:pivot] + w[swap] + (w[suffix:swap] + w[pivot] + w[swap + 1:len(w)])[::-1]


def kaprekarNumbers(p, q):
    k = []
    for i in range(p, q  + 1):
        s = i * i
        i_str = str(i)
        s_str = str(s)
        l = s_str[0:len(s_str) - len(i_str)] or '0'
        r = s_str[len(s_str) - len(i_str): len(s_str)]
        if int(l) + int(r) == i: k.append(i_str)
    if k: print(' '.join(k))
    else: print('INVALID RANGE')

def minimumDistances(a):
    nums = {}
    min = len(a);
    
    for i in range(len(a)):
        if a[i] in nums:
            if i - nums[a[i]] < min:
                min = i - nums[a[i]]
            nums[a[i]] = i
        else:
            nums[a[i]] = i
    
    if min == len(a): return -1
    else: return min

def howManyGames(p, d, m, s):
    count = 0
    #p = start price, m = min price, d is discount, s is cash
    while s >= p:
        count += 1
        s -= p
        if p - d >= m:
            p -= d
        else:
            p = m
    return count

def timeInWords(h, m):
    words = {
        0:"o' clock",
        1:'one',
        2:'two',
        3:'three',
        4:'four',
        5:'five',
        6:'six',
        7:'seven',
        8:'eight',
        9:'nine',
        10:'ten',
        11:'eleven',
        12:'twelve',
        13:'thirteen',
        14:'fourteen',
        15:'quarter',
        16:'sixteen',
        17:'seventeen',
        18:'eighteen',
        19:'nineteen',
        20:'twenty',
        30:'half'
    }
    
    if m == 0 or m == 15 or m == 30 or m == 45:
        suffix = ''
    elif m == 1:
        suffix = 'minute '
    else:
        suffix = 'minutes '
    
    if m <= 30:
        mid = 'past'
    else:
        m = 60 - m
        h = h + 1 if h < 12 else 1
        mid = 'to'
    
    hour = words[h]
    if m > 20 and m < 30:
        minute = words[20] + ' ' + words[m % 20]
    else:
        minute = words[m] 
    
    if m == 0:
        str = hour + ' ' + minute
    else:
        str = minute + ' ' +  suffix + mid + ' ' + hour
    
    return str

def chocolateFeast(n, c, m):
    count = n // c
    wraps = count
    bank = 0
    while wraps + bank >= m:
        temp = (wraps + bank) % m
        wraps = (wraps + bank) // m
        count += wraps
        bank = temp
    return count
    
def serviceLane(n, cases):
    ret = [0] * len(cases)
    for i in range(len(cases)):
        min = 4
        for j in range(cases[i][0], cases[i][1] + 1):
            if width[j] == 1:
                min = 1
                break
            if width[j] < min: min = width[j]
        ret[i] = min
    return ret

def workbook(n, k, arr):
    special = 0
    pagenum = 1
    for i in range(0, n):
        count = 1
        for j in range(1, arr[i] + 1):
            if j == pagenum:
                special += 1
            count += 1
            if count == k + 1 and j < arr[i]:
                count = 1
                pagenum += 1
        pagenum += 1
    
    return special;
