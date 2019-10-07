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
    
    
# arr = ['10101', '11100', '11010', '00101']
# print(queensAttack(5, 3, 4, 3, [[5,5],[4,2],[2,3],[5,2],[3,2]]))
# print(taumBday(10, 10, 1, 1, 1))
# arr = [[1,1],[1,1]]
# arr = [[1,2],[3,4]]
# arr = [[999336263,998799923],[998799923,999763019]]
# print(organizingContainers(arr))
# print(encryption('have a nice day'))
print(encryption('feedthedog'))
# print(encryption('chillout'))