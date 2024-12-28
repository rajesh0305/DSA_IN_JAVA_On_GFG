
class Solution:
    def intersectionWithDuplicates(self, a, b):
        a = list(set(a))
        b = list(set(b))
        a.extend(b)
        ans=[]
        map={}
        for i in a:
            if i not in map:
                map[i]=0
            map[i] += 1
            
        for i in map:
            if map[i]==2:
                ans.append(i)
        return ans
        # code here



#{ 
 # Driver Code Starts
#Position this line where user code will be pasted.
t = int(input().strip())
while t > 0:
    t -= 1
    # Read first array
    a = list(map(int, input().strip().split()))

    # Read second array
    b = list(map(int, input().strip().split()))

    #input()  # to consume the empty line

    # ADD Solution initialization
    sln = Solution()

    # Assuming numberofElementsInIntersection function is defined in Solution
    res = sln.intersectionWithDuplicates(a, b)

    # Sort the result
    res.sort()

    # Print the result
    if not res:
        print("[]")
    else:
        print(" ".join(map(str, res)))

    print("~")

# } Driver Code Ends