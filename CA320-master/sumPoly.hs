sumPoly :: [Int] -> [Int] -> [Int]
sumPoly a b
   | length a == 0 && length b == 0 = []
   | length a >= 1 && length b == 0 = a
   | length b >= 1 && length a == 0 = b
   | length b == 1 && length a == 1 = [head a + head b]
   | length a > 1 && length b <= 1 = (head a + head b):tail a
   | length b > 1 && length a <= 1 = (head a + head b):tail b
   | length a > 1 && length b > 1 = (head a + head b):sumPoly (tail a) (tail b)