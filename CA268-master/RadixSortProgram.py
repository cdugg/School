def radixsort(lst, number_of_passes):
   if lst != None:
      for p in range(number_of_passes):
         lo = [x for x in lst if x & (1 << p) == 0] 
         hi = [x for x in lst if x & (1 << p) != 0]
         lst = lo + hi 

   return lst
