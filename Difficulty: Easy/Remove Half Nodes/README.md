<h2><a href="https://www.geeksforgeeks.org/problems/remove-half-nodes/1">Remove Half Nodes</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given A binary Tree. Your task is to remove all the half nodes (which has only one child). R</span><span style="font-size: 18px;">eturns the root node of the modified tree after removing all the half nodes, i.e. the ones having just a single child node (Print the inorder traversal of the returned tree).</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
&nbsp;        7
&nbsp;      /   \
&nbsp;     7     8
&nbsp;    / 
&nbsp;   2<strong>
Output: </strong>2 7 8&nbsp;</span>
<span style="font-size: 18px;"><strong>Input:</strong>
&nbsp;        2
&nbsp;      /   \
&nbsp;     7     5
&nbsp;      \      \
&nbsp;       9      1
&nbsp;      /  \
&nbsp;     11   4<strong>
Output: </strong>11 9 4 2 1 </span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n).<br><strong>Expected Auxiliary Space:&nbsp;</strong>O(height of the binary tree).<br></span><span style="font-size: 18px;"><strong>Constraints:</strong><br>1&lt;=number of nodes&lt;=10<sup>4</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;