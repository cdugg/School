evalPoly :: Int -> [Int] -> Int
evalPoly a b
   | length b > 1 = (evalPoly (a) (take ((length b) - 1) b)) + (a ^ ((length b) - 1) * last b)
   | length b == 1 = head b
   | length b == 0 = 0