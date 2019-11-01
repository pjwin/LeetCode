import math
import os
import random
import re
import sys
import time


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
    return b * min(bc, wc + z) + w * min(wc, bc + z)

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

def flatlandSpaceStations(n, c):
    if n == len(c): return 0
    max = 0
    c.sort()
    l = c[0]
    r = c[1] if len(c) > 1 else c[0]
    j = 2
    for i in range(n):
        if min(abs(i - l), abs(i - r)) > max: max = min(abs(i - l),abs(i - r))
        if i == r:
            l = r
            if j < len(c):
                r = c[j]
                j += 1;
    return max           

def fairRations(B):
    oc = 0
    count = 0
    prev = -1
    for i in range(len(B)):
        if B[i] % 2 != 0:
            oc = oc + 1
            if prev == -1:
                prev = i
            else:
                count = count + i - prev
                prev = -1
    if oc % 2 != 0:
        return 'NO'
    
    return count * 2

def fairRations2(B):
    sum = 0
    count = 0
    for i in B:
        sum = sum + i
        if i % 2 != 0:
            count = count + 2
    if sum % 2 != 0:
        return 'NO'
    return count

def cavityMap(grid):
    for i in range(1, len(grid) - 1):
        for j in range(1, len(grid) - 1):
            if grid[i - 1][j] < grid[i][j] and grid[i + 1][j] < grid[i][j] and grid[i][j - 1] < grid[i][j] and grid[i][j + 1] < grid[i][j]:
                grid[i] = grid[i][0:j] + 'X' + grid[i][j + 1:]
    return grid

def stones(n, a, b):
    nums = []
    sum = (n-1) * a
    nums.append(sum)
    inc = b - a
    for i in range(1, n):
        sum += inc
        nums.append(sum)
    return nums

def gridSearch(G, P):
    g_r = len(G)
    g_c = len(G[0])
    p_r = len(P)
    p_c = len(P[0])
    
    for i in range(0, g_r - p_r + 1):
        for m in re.finditer('(?=' + P[0] + ')', G[i]):
            if gridHelp(G, P, i, p_r, m.start(), p_c) == 'NO':
                continue
            else:
                return 'YES'
    return 'NO'
            
def gridHelp(G, P, i, p_r, l, p_c):
    for j in range(1, p_r):
        if G[i + j][l:l + p_c] != P[j]:
            return 'NO'
    return 'YES'

def happyLadybugs(b):
    if len(b) == 1:
        if b[0] != '_':
            return 'NO'
        else:
            return 'YES'
    inorder = True
    chars = {}
    for i in range(len(b)):
        chars[b[i]] = chars[b[i]] + 1 if b[i] in chars else 1
        if b[i] != b[i - 1 if i > 0 else i + 1] and b[i] != b[i + 1 if i < len(b) - 1 else i - 1] and b[i] != '_':
            inorder = False

    if not inorder and '_' not in chars:
        return 'NO'
    
    for k, v in chars.items():
        if k != '_' and v == 1:
            return 'NO'
    
    return 'YES'

def surfaceArea(A):
    total = 0
    bottom = len(A) * len(A[0])
    top = bottom
    total = top + bottom
    
    for i in range(0, len(A)):
        for j in range(0, len(A[0])):
            up = 0
            down = 0
            left = 0
            right = 0
            
            #up
            if i == 0:
                up = A[i][j]
            else:
                if A[i - 1][j] < A[i][j]:
                    up = A[i][j] - A[i - 1][j]
            
            #down 
            if i == len(A) - 1:
                down = A[i][j]
            else:
                if A[i + 1][j] < A[i][j]:
                    down = A[i][j] - A[i + 1][j]
                    
            #left 
            if j == 0:
                left = A[i][j]
            else:
                if A[i][j - 1] < A[i][j]:
                    left = A[i][j] - A[i][j - 1]

            #right 
            if j == len(A[0]) - 1:
                right = A[i][j]
            else:
                if A[i][j + 1] < A[i][j]:
                    right = A[i][j] - A[i][j + 1]
    
            
            total += up
            total += down
            total += left
            total += right
            
    return total

def absolutePermutation(n, k):
    nums = set()
    ret = []
        
    for i in range(1, n + 1):
        nums.add(i)
    
    for i in range(1, n + 1):
        prev = i - k
        if i - k in nums:
            nums.remove(i - k)
            ret.append(str(i - k))
        elif i + k in nums:
            nums.remove(i + k)
            ret.append(str(i + k))
        else:
            ret.clear()
            ret.append(str(-1))
            return ret
    return ret

def absolutePermutation2(n, k):
    #this one is faster
    ret = []
    c = 1
    if n % k != 0:
        return [-1]
    for i in range(1, n + 1):
        if c <= k:
            ret.append(i + k)
        else:
            ret.append(i - k)
        c += 1
        if c > 2 * k:
            c = 1
    return ret

def bomberMan(n, grid):
    if n == 0 or n == 1:
        return grid
    if n % 2 == 0:
        return list(['O' * len(grid[0])] * len(grid))
    
    #2
    for i in range(len(grid)):
        grid[i] = grid[i].replace('.', '2')
        grid[i] = list(grid[i])
    
    #3
    grid = [[x.replace('O','.') for x in l] for l in grid]
    grid = explode(grid)
    
    grid3 = [''.join([x.replace('2','O') for x in l]) for l in grid]
    if n == 3:
        return grid3
    #4
    grid = [[x.replace('.','4') for x in l] for l in grid]
    
    #5
    grid = [[x.replace('2','.') for x in l] for l in grid]
    grid = explode(grid)
    
    grid5 = [''.join([x.replace('4','O') for x in l]) for l in grid]
    
    if ((n - 1) / 2) % 2 == 1:
        return grid3
    else:
        return grid5

def explode(grid):
    for i in range(len(grid)):

        for j in range(len(grid[0])):
            #up
            if grid[i][j] == '.':
                continue
            if i > 0 and grid[i - 1][j] == '.':
                grid[i][j] = 'X'
            #down
            elif i < len(grid) - 1 and grid[i + 1][j] == '.':
                grid[i][j] = 'X'
            #left:
            elif j > 0 and grid[i][j - 1] == '.':
                grid[i][j] = 'X'
            #right
            elif j < len(grid[i]) - 1 and grid[i][j + 1] == '.':
                grid[i][j] = 'X'
    return [[x.replace('X','.') for x in l] for l in grid]
