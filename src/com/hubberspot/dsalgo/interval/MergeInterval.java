package com.hubberspot.dsalgo.interval;

import static java.util.Comparator.comparingInt;

import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

   public static class Interval {
      int start;
      int end;

      public Interval(int start, int end) {
         this.start = start;
         this.end = end;
      }
   }

   List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      if (intervals == null || intervals.isEmpty())
         return intervals;
      List<Interval> result = new LinkedList<>();
      int i = 0;
      while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
         result.add(intervals.get(i));
         i++;
      }
      while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
         Interval current = intervals.get(i);
         newInterval.start = Math.min(current.start, newInterval.start);
         newInterval.end = Math.max(current.end, newInterval.end);
         i++;
      }
      result.add(newInterval);
      while (i < intervals.size()) {
         result.add(intervals.get(i));
         i++;
      }
      return result;
   }

   public List<Interval> merge(List<Interval> intervals) {
      if (intervals.size() < 2) {
         return intervals;
      }
      intervals.sort(comparingInt(interval -> interval.start));
      List<Interval> mergedIntervals = new LinkedList<>();
      Interval interval = intervals.get(0);
      int start = interval.start;
      int end = interval.end;
      for (Interval curr : intervals) {
         if (curr.start <= end) {
            end = Math.max(curr.end, end);
         } else {
            mergedIntervals.add(new Interval(start, end));
            start = curr.start;
            end = curr.end;
         }
      }
      mergedIntervals.add(new Interval(start, end));
      return mergedIntervals;
   }

   List<Interval> mergeInterval(List<Interval> intervals) {
      if (intervals.size() < 2)
         return intervals;
      intervals.sort(comparingInt(a -> a.start));
      List<Interval> result = new LinkedList<>();
      Interval first = intervals.get(0);
      int start = first.start;
      int end = first.end;
      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);
         if (current.start <= end) {
            end = Math.max(current.end, end);
         } else {
            result.add(new Interval(start, end));
            start = current.start;
            end = current.end;
         }
      }
      result.add(new Interval(start, end));
      return result;
   }

   public static void main(String[] args) {
      MergeInterval mergeInterval = new MergeInterval();
      List<Interval> intervals = new LinkedList<>();
      intervals.add(new Interval(0, 1));
      intervals.add(new Interval(3, 5));
      intervals.add(new Interval(7, 8));
      intervals.add(new Interval(9, 10));
      List<Interval> merge = mergeInterval.insert(intervals, new Interval(2, 6));
      for (Interval a : merge) {
         System.out.println(a.start + "," + a.end);
      }

      //        List<Interval> intervals1 = new LinkedList<>();
      //        intervals1.add(new Interval(6, 7));
      //        intervals1.add(new Interval(2, 4));
      //        intervals1.add(new Interval(5, 9));
      //        List<Interval> merge1 = mergeInterval.mergeInterval(intervals1);
      //        for (Interval a : merge1) {
      //            System.out.println(a.start + "," + a.end);
      //        }
      //
      //        List<Interval> intervals2 = new LinkedList<>();
      //        intervals2.add(new Interval(1, 4));
      //        intervals2.add(new Interval(2, 6));
      //        intervals2.add(new Interval(3, 5));
      //        List<Interval> merge2 = mergeInterval.mergeInterval(intervals2);
      //        for (Interval a : merge2) {
      //            System.out.println(a.start + "," + a.end);
      //        }
   }
}
