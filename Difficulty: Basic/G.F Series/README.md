<h2><a href="https://www.geeksforgeeks.org/problems/gf-series3535/1?page=3&category=Recursion&sortBy=submissions">G.F Series</a></h2><h3>Difficulty Level : Difficulty: Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Siddhant made a special series and named it as G.F Series. The series follows this trend &nbsp;<strong>T<sub>n</sub>=(T<sub>n-2</sub>)<sup>2</sup>-(T<sub>n-1</sub>)</strong> &nbsp;in which the first and the second term are 0 and 1 respectively. Help Siddhant to find the first <strong>n</strong> terms of the series.<br><br><strong>Note</strong>: Print a white space (" ") after every integer and a newline character after every testcase. <br></span></p>
<p><strong><span style="font-size: 18px;">Examples</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">n = 3</span>
<strong><span style="font-size: 18px;">Output: </span></strong><span style="font-size: 18px;">0 1 -1</span>
<strong><span style="font-size: 18px;">Explanation: </span></strong><span style="font-size: 18px;">First-term is given as 0 and the second term is 1. So the T<sub>3</sub> = (T<sub>3-2</sub>)<sup>2</sup> - (T<sub>3-1</sub>) = T<sub>1</sub><sup>2</sup> - T<sub>2</sub> = 0<sup>2</sup> - 1 = -1</span></pre>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">n = 6</span>
<strong><span style="font-size: 18px;">Output: </span></strong><span style="font-size: 18px;">0 1 -1 2 -1 5</span>
<strong><span style="font-size: 18px;">Explanation:
</span></strong><span style="font-size: 18px;">T<sub>1</sub> : 0
T<sub>2</sub> : 1
T<sub>3</sub> : -1
T<sub>4</sub> = (1)<sup>2</sup> - (-1) = 2
T<sub>5</sub> = (-1)<sup>2</sup> - (2) = 1 - 2 = -1
T<sub>6</sub> = (2)<sup>2</sup> - (-1) = 4 + 1 = 5 </span></pre>
<p><span style="font-size: 18px;"><strong>Your Task:&nbsp;&nbsp;</strong></span><br><span style="font-size: 18px;">You don't need to read input. Your task is to complete the function&nbsp;<strong>gfSeries</strong>() which takes an integer n as an input parameter and print first n term of the series.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity</strong>: O(n)<br><strong>Expected Auxiliary Space:</strong> O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>2 &lt;= n &lt;= 15</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematical</code>&nbsp;<code>Recursion</code>&nbsp;<code>Algorithms</code>&nbsp;