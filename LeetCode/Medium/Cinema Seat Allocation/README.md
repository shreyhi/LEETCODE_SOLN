# Cinema Seat Allocation

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 19, 2026 |
| **Tags** | Array, Hash Table, Greedy, Bit Manipulation |
| **Link** | [View Problem](https://leetcode.com/problems/cinema-seat-allocation/) |
| **Runtime** | 19 ms |
| **Memory** | 50.7 MB |

## Problem Description

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/02/14/cinema_seats_1.png" style="width: 400px; height: 149px;"></p>

<p>A cinema has <code>n</code> rows of seats, numbered from 1 to <code>n</code>. Each row has 10 seats, numbered from 1 to 10.</p>

<p>You are given a 2D integer array <code data-end="170" data-start="155">reservedSeats</code>, where <code data-end="212" data-start="178">reservedSeats[i] = [row<sub>i</sub>, seat<sub>i</sub>]</code> means that seat <code data-end="236" data-start="229">seat<sub>i</sub></code> in row <code data-end="250" data-start="244">row<sub>i</sub></code> is already reserved.</p>

<p>A four-person group must be assigned to four seats in the <strong>same</strong> row. The group can be seated in one of the following seat blocks:</p>

<ul>
	<li>seats <code data-end="423" data-start="411">2, 3, 4, 5</code></li>
	<li>seats <code data-end="444" data-start="432">4, 5, 6, 7</code></li>
	<li>seats <code data-end="465" data-start="453">6, 7, 8, 9</code></li>
</ul>

<p>A block can be used only if <strong>none</strong> of its seats are reserved. Each seat can be assigned to <strong>at most </strong>one group.</p>

<p>Return an integer denoting the <strong>maximum</strong> number of four-person groups that can be assigned.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/02/14/cinema_seats_3.png" style="width: 400px; height: 96px;"></p>

<pre><strong>Input:</strong> n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The figure above shows an optimal allocation of four groups. Seats marked in blue are already reserved, and each set of four contiguous seats marked in orange is assigned to one group.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= reservedSeats.length &lt;= min(10 * n, 10<sup>4</sup>)</code></li>
	<li><code>reservedSeats[i] == [row<sub>i</sub>, seat<sub>i</sub>]</code></li>
	<li><code>1 &lt;= row<sub>i</sub> &lt;= n</code></li>
	<li><code>1 &lt;= seat<sub>i</sub> &lt;= 10</code></li>
	<li>All <code>reservedSeats[i]</code> are distinct.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easy Java Solution Using HashMap
**Author**: [@shreya12ria](https://leetcode.com/shreya12ria/)
**Upvotes**: 23 👍
**Link**: [View Original Post](https://leetcode.com/problems/cinema-seat-allocation/solutions/1760077/)

---

I have solved this question using HashMap and Simple If-Else.

First try to understand at max how many such group of 4 persons you can allow in a row if all seats are available? The answer is 2. How? 
As per the question, we know that there are 3 sections -
1. Left Aisle -> starts from column 2 and ends at column 5
2. Middle -> starts from column 4 and ends at column 7
3. Right Aisle -> starts from column 6 and ends at column 9

Column 1 & 10 doesnt have any importance.

Now, Let\'s say I take the middle (4-7) to allow group of 4 person, then I wont be able to use either of the aisle. In this case I allowed 1 group.

Now, Let\'s say, I take both the aisles instead of middle i.e., I put 1 group of 4 people in left aisle and another 1 group of 4 people in right aisle, then I wont be able to use middle. In this case I allowed 2 groups.

Hence I can say that if column from 2-9 is available then I will greedily choose the two aisles instead of middle and thus allowing max groups in a particular row. 

What if either of the aisle is blocked? 

Whenever an aisle is blocked there can be two scenarios -

1. Only left half (2-3 column) of left aisle is blocked and not the right half of left aisle which lies in middle(4-5 column). Similarly, only right half (8-9 column) of right aisle is blocked and not the left half of right aisle which lies in middle(6-7 column) or both.
			a. I can use the middle if both the aisles are blocked. Then I can allow max of 1 group which is in the middle.
			b. I can use either middle or any one of the aisle which is free. Then I can allow max of 1 group which can be in the middle or either of the free aisle.
			
Hence in this scenario, I can allow a max of 1 group.

2. Right Half of Left Aisle (4-5 columns) or Left Half of Right Aisle (6-7 columns) or both is blocked which lies in middle (4-7 columns).
			a. I can use either of the free aisle. Then I can allow max of 1 group which is in either of the free aisle.
			b. I cannot allow group because if both aisle blocked based in above columns placement, then it blocks all the section. Then 0 groups allowed.
			
Hence in this scenario, I can allow a max of 1 group if either of the aisle is free else 0.

What if middle is blocked?

Whenever middle is blocked there can be 1 scenario -

1. Only left half (4-5 column) of middle and right half(4-5) of left aisle is blocked. Similarly, only right half (6-7 column) of middle and left half of right aisle is blocked or both.
			a. I can use either of the free aisle which is free. Then I can allow max of 1 group which can be in the middle or either of the free aisle or else 0 if both aisle blocked.
			
Hence in this scenario, I can allow a max of 1 group if either of the aisle is free or else 0 group.

Now that I am clear on positioning and accordingly allocationg, I need to form the conditions based on which I will keep on adding the max groups that I can allow in every row.

One catch here -> Let\'s say there are **n** rows. In the **reservedSeats** array, it will have only those row information for which certain seats/columns are blocked. This means that the rows for which all seats are available can be easily taken into consideration without any checks. Based on the above explanations, I can confidently say that, if any row has all seats available, then I can allow max of 2 groups. Then I can say
	 ****Initial ans = 2(TotalNoOfRows-noOfRowsNotHavingAllSeatsAvailable)**** 


Steps :

1. Create a Hashmap to store row to columns/seats mapping. For each row what all columns/seats are blocked. Row is key and value is List of columns/seats blocked in that row.
2. **n** is the total no of rows. Size of HashMap will give the no of rows not having all seats available.
3. Take initial ans =  2*(n-size of hashmap)
4.  Run for loop to loop through hashmap.
		a. For each row, store the list of columns(seats) in a List.
		b. Initialize 3 boolean variable -> leftaisle : false, rightfalse : false, middle : false. Here false means it is not blocked.
		b. Loop through the above list
						i. Check if the column(seat) lies in left aisle. If yes, then make leftaisle : true
						ii. Check if the column(seat) lies in right aisle. If yes, then make rightaisle : true
						iii. Check if the column(seat) lies in middle. If yes, then make middle : true
						iv. Check if all the three boolean variables(three sections) are blocked i.e., having true as values, then terminate the loop. This step is to avoid further checks as it doesn\'t make any sense to keep on checking if at any point I found that I cannot use any of the sections.
		c. Check if leftaisle is false which means its free, then add 1 to ans.
		d. Check if rightaisle is false which means its free, then add 1 to ans.
		e. Check if middle is false which means its free but both the aisles are true which means its blocked, then add 1 to ans;
5. Return ans;	


```
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        
        for(int[] i : reservedSeats){
            map.putIfAbsent(i[0],new ArrayList<>());
            map.get(i[0]).add(i[1]);
        }
        
        
        int ans = 2*(n - map.size());
        
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> seats = entry.getValue();
            
            boolean isLeftAisle = false, isRightAisle = false, isMiddle = false;
            
            for(int seat : seats){
                
                if(seat >= 2 && seat <= 5)
                    isLeftAisle = true;
                if(seat >= 6 && seat <= 9)
                    isRightAisle = true;
                if(seat >=4 && seat <= 7)
                    isMiddle = true;
                    
                if(isLeftAisle && isRightAisle && isMiddle){
                    break;
                }
            }
            
            if(!isLeftAisle)
                ans += 1;
            if(!isRightAisle)
                ans += 1;
            if(isLeftAisle && isRightAisle && !isMiddle)
                ans += 1;
            
        }
       
        return ans;
        
    }
}
```

</details>
