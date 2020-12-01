mLengths :: Int -> [Int]
mLengths a
   | mod a 4 == 0 && mod a 100 /= 0 = [31,29,31,30,31,30,31,31,30,31,30,31]
   | mod a 400 == 0 = [31,29,31,30,31,30,31,31,30,31,30,31]
   | otherwise = [31,28,31,30,31,30,31,31,30,31,30,31]