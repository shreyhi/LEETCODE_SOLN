# Maximize Consecutive Elements in an Array After Modification

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | November 20, 2026 |
| **Tags** | Array, Dynamic Programming, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/) |
| **Runtime** | 37 ms |
| **Memory** | 74.3 MB |

## Problem Description

<p>You are given a <strong>0-indexed</strong> array <code>nums</code> consisting of <strong>positive</strong> integers.</p>

<p>Initially, you can increase the value of <strong>any</strong> element in the array by <strong>at most</strong> <code>1</code>.</p>

<p>After that, you need to select <strong>one or more</strong> elements from the final array such that those elements are <strong>consecutive</strong> when sorted in increasing order. For example, the elements <code>[3, 4, 5]</code> are consecutive while <code>[3, 4, 6]</code> and <code>[1, 1, 2, 3]</code> are not.</p>

<p>Return <em>the <strong>maximum</strong> number of elements that you can select</em>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,5,1,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can increase the elements at indices 0 and 3. The resulting array is nums = [3,1,5,2,1].
We select the elements [<u><strong>3</strong></u>,<u><strong>1</strong></u>,5,<u><strong>2</strong></u>,1] and we sort them to obtain [1,2,3], which are consecutive.
It can be shown that we cannot select more than 3 consecutive elements.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,7,10]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The maximum consecutive elements that we can select is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java/C++/Python] DP
**Author**: [@lee215](https://leetcode.com/lee215/)
**Upvotes**: 72 👍
**Link**: [View Original Post](https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/solutions/4742395/)

---

# **Intuition**
Sort input `A` first.
<br>

# **Solution 1: DP**

`dp[a]` is the maximum length of consecutive sequence ending with `a`.

Iterates through each `a` in the sorted `A`.
We can use `a` as `a + 1`, so we update `dp[a + 1] = dp[a] + 1`
We can use `a` as `a` itself, so we update `dp[a] = dp[a - 1] + 1`

Finally we return the max length in `dp` values.

Time `O(sort) + O(n)`
Space `O(sort) + O(n)`


**Java**
```java
    public int maxSelectedElements(int[] A) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        Arrays.sort(A);
        int res = 0;
        for (int a : A) {
            dp.put(a + 1, dp.getOrDefault(a, 0) + 1);
            dp.put(a, dp.getOrDefault(a - 1, 0) + 1);
            res = Math.max(res, Math.max(dp.get(a), dp.get(a + 1)));
        }
        return res;
    }
```

**C++**
```cpp
    int maxSelectedElements(vector<int>& A) {
        unordered_map<int, int> dp;
        sort(A.begin(), A.end());
        int res = 0;
        for (int& a : A) {
            res = max(res, dp[a + 1] = dp[a] + 1);
            res = max(res, dp[a] = dp[a - 1] + 1);
        }
        return res;
    }
```

**Python**
```py
    def maxSelectedElements(self, A: List[int]) -> int:
        dp = defaultdict(int)
        A.sort()
        for a in A:
            dp[a + 1] = dp[a] + 1
            dp[a] = dp[a - 1] + 1
        return max(dp.values())
```
<br>

# **Solution 2: O(1) Space**
Same as Solution 1, but save the space of `dp`

**Java**
```java
    public int maxSelectedElements(int[] A) {
        Arrays.sort(A);
        int pre = -10, res = 1, c1 = 1, c2 = 1;
        for (int a : A) {
            if (a == pre) {
                c2 = c1 + 1;
            } else if (a == pre + 1) {
                c1++;
                c2++;
            } else if (a == pre + 2) {
                c1 = c2 + 1;
                c2 = 1;
            } else {
                c1 = c2 = 1;
            }
            res = Math.max(res, Math.max(c1, c2));
            pre = a;
        }
        return res;
    }
```

**C++**
```cpp
    int maxSelectedElements(vector<int>& A) {
        sort(A.begin(), A.end());
        int pre = -10, res = 1, c1 = 1, c2 = 1;
        for (int& a : A) {
            if (a == pre) {
                c2 = c1 + 1;
            } else if (a == pre + 1) {
                c1++;
                c2++;
            } else if (a == pre + 2) {
                c1 = c2 + 1;
                c2 = 1;
            } else {
                c1 = c2 = 1;
            }
            res = max(res, max(c1, c2));
            pre = a;
        }
        return res;
    }
```

**Python**
```py
    def maxSelectedElements(self, A: List[int]) -> int:
        A.sort()
        pre = -10
        res = c1 = c2 = 1
        for a in A:
            if a == pre:
                c2 = c1 + 1
            elif a == pre + 1:
                c1, c2 = c1 + 1, c2 + 1
            elif a == pre + 2:
                c1, c2 = c2 + 1, 1
            else:
                c1 = c2 = 1
            res = max(res, c1, c2)
            pre = a
        return res
```

Time `O(sort) + O(n)`
Space `O(sort) + O(1)`


</details>
