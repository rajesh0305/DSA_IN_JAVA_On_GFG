<h2><a href="https://www.geeksforgeeks.org/problems/joey-doesnt-share-food5712/1?page=10&difficulty=Hard&sortBy=submissions">Joey doesn't share food</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Every friends fan know that joey loves food and monica loves to cook. So, on a occassion of thanksgiving monica made n&nbsp;types of food containing exactly 6 ingredients each. Monica is an excellent cook so she can cook food by adding any ingredient at any order. All ingredients contains protein on the scale of 1 to 10^6. Now, Chandler invented the fun game where everyone needs to find the successive protein rate in all n&nbsp;food of the ingredient on the top(6th ingredient is on top). Ross being the most curious wants to finish this game before dinner, so he wants your help to complete the task.</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>nums = {{1,2,3,4,5,6}, 
{8,9,10,11,12,13}}
<strong>Output: </strong>1
<strong>Explanation: </strong>No matter how the arrangement is
the answer will be 1.</span>
</pre>
<p><strong><span style="font-size: 18px;">Example 2:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">nums = {{1,2,3,4,5,6},
{2,3,4,5,6,7}, {3,4,5,6,7,10},
{4,5,6,7,8,9}}
<strong>Output: </strong>4
<strong>Explanation: </strong>If ingredients are arranged in 
any order and let say if don't rearrange it, 
ans will be 2.</span><span style="font-size: 18px;"><code>
As 6 7 or 10 9. These are the successive 
protein rate existing.
If we arrange it in order:
1 2 3 4 5 6
2 3 4 5 6 7
3 4 6 7 10 5
4 5 6 7 9 8
Now the answer will be 4.
As 6 7 5 8, so these protein rates are successive
(5 6 7 8).</code></span></pre>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Your Task:&nbsp;</strong>You don't need to read or print anything. Your task is to complete the function<strong>&nbsp;MaxmimumLength()&nbsp;</strong>which takes details of each food i,e nums as input parameter and returns the length of largest chain formed.</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n<sup>2</sup>)<br><strong>Expected Space Complexity:&nbsp;</strong>O(n)</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= n &lt;= 10<sup>5</sup><br>1 &lt;= protein scale &lt;= 10<sup>6</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Hash</code>&nbsp;<code>DFS</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;