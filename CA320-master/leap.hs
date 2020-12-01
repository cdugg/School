leap :: Int -> Bool
leap a
   | mod a 4 == 0 && mod a 100 /= 0 = True
   | mod a 400 == 0 = True
   | otherwise = False