# CS310 Lab: Sorting Algorithms — Report

**Author:** Pranaya Khadgi Shahi  
**Date:** February 2026

---

## What I still need to do (for myself)

1. **Screenshots (Deliverable 1):** Run each of the four programs from the command line (java InsertionSort, java SelectionSort, etc). Take a screenshot of each run and add them to this report before exporting to PDF.
2. **Simulation table (Deliverable 2):** Compile all files (javac *.java) and run java Simulation. It can take a few minutes because of the 1000 runs. Copy the printed table from the console into the table below, or just paste the "Single table format for report" output.
3. **Graphs (Deliverable 2):** Using the table, make two line charts (one for ascending, one for descending) in Excel or Google Sheets and paste them into the report.
4. **Export to PDF:** Open this in Word or Google Docs, add the screenshots and graphs, then export as PDF. Submit the PDF plus the five .java files on BrightSpace.

---

## Deliverable 1: Four sorting programs and sample runs

I implemented the four sorting algorithms (insertion, selection, merge, quick) each in its own file. Each one has a main method that runs on the sample array {10, 50, 16, 16, 2, 5} and prints the sorted array and the step count. Below are the four screenshots showing the output of each program when I run it from the command line.

**1. InsertionSort**

![InsertionSort sample run](assets/c__Users_prana_AppData_Roaming_Cursor_User_workspaceStorage_c8e94249e02e722426e0990273c28111_images_Screenshot_2026-02-21_202842-571efd7f-5e3b-407c-aee6-fb0bb81a8f2f.png)

**2. SelectionSort**

![SelectionSort sample run](assets/c__Users_prana_AppData_Roaming_Cursor_User_workspaceStorage_c8e94249e02e722426e0990273c28111_images_Screenshot_2026-02-21_202928-f8132ef4-b35f-4de1-b835-c859135fb12f.png)

**3. MergeSort**

![MergeSort sample run](assets/c__Users_prana_AppData_Roaming_Cursor_User_workspaceStorage_c8e94249e02e722426e0990273c28111_images_Screenshot_2026-02-21_202903-1a1c2804-09b4-4338-9869-a8a56f6dce3e.png)

**4. QuickSort**

![QuickSort sample run](assets/c__Users_prana_AppData_Roaming_Cursor_User_workspaceStorage_c8e94249e02e722426e0990273c28111_images_Screenshot_2026-02-21_202916-3c86ff65-0355-45a0-982e-afe491ece7e4.png)

---

## Deliverable 2: Simulation table and graphs

### How I did the simulation

For each input size N = 1K, 5K, 10K, 15K, 20K I did three things. For random values I generated N random numbers in the range 0 to N, ran each algorithm 1000 times, and took the average of the steps. For ascending order I first generated random numbers then sorted them in ascending order (using a separate sort method as the lab said we could), then ran each algorithm once on that sorted array and recorded the steps. For descending I did the same but sorted in descending order first. So the table has for each size the average steps for random (over 1000 runs), and the steps for one run on ascending and one run on descending.

### Table: Average steps by input size and input order

*(Order in each cell: Insertion | Selection | Merge | Quick.)*

| Input size | Ascending (avg steps) | Descending (avg steps) | Random (avg steps) |
|------------|------------------------|-------------------------|---------------------|
|            | Ins \| Sel \| Merge \| Quick | Ins \| Sel \| Merge \| Quick | Ins \| Sel \| Merge \| Quick |
| 1K         | 2997 \| 499500 \| 25995 \| 1501497 | 1000381 \| 500746 \| 26084 \| 741900 | 501622 \| 501483 \| 29658 \| 24518 |
| 5K         | 14997 \| 12497500 \| 160619 \| 37507497 | 25001852 \| 12503544 \| 159699 \| 17813710 | 12515442 \| 12507480 \| 183842 \| 154990 |
| 10K        | 29997 \| 49995000 \| 346239 \| 150014997 | 100003317 \| 50007310 \| 344543 \| 71636190 | 49999925 \| 50014979 \| 397680 \| 337489 |
| 15K        | 44997 \| 112492500 \| 538595 \| 337522497 | 225005484 \| 112510842 \| 537832 \| 159237430 | 112528293 \| 112522478 \| 621531 \| 531074 |
| 20K        | 59997 \| 199990000 \| 742479 \| 600029997 | 400007259 \| 200014470 \| 739010 \| 286734709 | 199989794 \| 200029978 \| 855361 \| 729097 |

### How to make the two graphs

I made two graphs. Here’s how you can do it in **Excel** or **Google Sheets**.

**Graph 1 — Already sorted (ascending)**

1. Open Excel or Google Sheets.
2. Put the data in columns:
   - **Column A:** Input size labels: `1K`, `5K`, `10K`, `15K`, `20K` (or use numbers 1000, 5000, 10000, 15000, 20000 for the x-axis).
   - **Column B (Insertion):** 2997, 14997, 29997, 44997, 59997
   - **Column C (Selection):** 499500, 12497500, 49995000, 112492500, 199990000
   - **Column D (Merge):** 25995, 160619, 346239, 538595, 742479
   - **Column E (Quick):** 1501497, 37507497, 150014997, 337522497, 600029997
3. Select the range (all five columns).
4. Insert → Chart → **Line chart** (lines with points).
5. Set **x-axis** = input size (column A). **y-axis** = steps. You should see four lines (Insertion, Selection, Merge, Quick).
6. Add a title like “Performance when elements are already sorted (ascending)”.
7. Copy the chart and paste it into your report (Word/Google Docs) where you want Graph 1.

**Graph 2 — Sorted in descending order**

1. Same as above, but use the **Descending** column from the table:
   - **Column B (Insertion):** 1000381, 25001852, 100003317, 225005484, 400007259
   - **Column C (Selection):** 500746, 12503544, 50007310, 112510842, 200014470
   - **Column D (Merge):** 26084, 159699, 344543, 537832, 739010
   - **Column E (Quick):** 741900, 17813710, 71636190, 159237430, 286734709
2. Insert → Line chart, same as Graph 1.
3. Title: “Performance when elements are sorted in descending order”.
4. Copy and paste into the report where you want Graph 2.

**Tip:** If the y-axis numbers are huge and the Insertion/Merge lines look flat, that’s normal—Quick and Selection have much bigger values. You can leave it that way (shows Quick/Selection dominating) or make two separate charts (one for Insertion+Merge, one for Selection+Quick) if your professor likes that. For the lab, one chart per graph with all four lines is usually fine.

---

## Deliverable 3: Analysis (answers to the four questions)

### (a) When elements are already sorted (ascending), which algorithm's performance is the worst? What is the reason?

From the data I got, quick sort was the worst when the input is already sorted in ascending order. In my implementation I used the last element as the pivot. So when the array is already sorted, the last element is always the biggest and every time we partition we get really unbalanced splits—almost everything goes to the left and nothing to the right. So the recursion goes really deep and we end up doing something like O(N²) comparisons. Insertion sort does well here because each element is already in place so it's like O(N). Merge sort is O(N log N) either way. So the worst one in this case is quick sort and the reason is basically that picking the last element as pivot on sorted data gives the worst case.

### (b) When elements are sorted in descending order, which algorithm's performance is the worst? What is the reason?

When the input is sorted in descending order, insertion sort was the worst in my results. For insertion sort, every new element you look at is smaller than everything you've already "sorted", so you have to compare and shift it all the way to the front every time. So you get a lot of comparisons and shifts, like O(N²) with a big constant. Selection sort is also O(N²) but it doesn't do as many shifts. Merge sort stays O(N log N). So insertion sort on descending input was the worst for me, and the reason is that each insertion has to move the element through the whole sorted part.

### (c) Considering all the tabular data, which sorting algorithm's performance on average is better than the others? Why?

Looking at the whole table, merge sort had the best performance on average. Its step count goes up like N log N as N gets bigger, and it does that for random, ascending, and descending—there's no bad case. Quick sort can blow up when the input is sorted (like we saw in (a)). Insertion and selection both grow like N² so they get bad for larger sizes. So overall merge sort's numbers stayed the lowest for big N and it didn't have any weird spikes. The reason is that merge sort's worst case and average case are both O(N log N), so it's consistent.

### (d) Considering all the tabular data, which sorting algorithm's performance on average is worse than the others? Why?

On average over all the data, insertion sort and selection sort did the worst, and usually insertion was a bit worse in terms of total steps. Both of them are O(N²)—insertion does a lot of comparisons and shifts especially on random and descending, and selection always does around N²/2 comparisons no matter what. So when you look at the table for 10K, 15K, 20K their numbers get really high compared to merge and quick sort which grow like N log N. So the worst average performance is from insertion (and selection), and the reason is they're both quadratic so they can't avoid doing on the order of N² operations, while the other two scale better.

---

## Submission checklist

- [ ] Deliverable 1: Four program files and four screenshots of their sample runs
- [ ] Deliverable 2: Simulation program (Simulation.java), table filled in, and two graphs
- [ ] Deliverable 3: This report with answers (a)–(d) and the graphs
- [ ] Export to PDF and submit the PDF plus the five .java files on BrightSpace

---

*End of report.*
