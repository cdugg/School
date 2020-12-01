type PDA = (Int,[Int],[Transition])
type Transition = ((Int,String,String),(Int,String))
type Configuration = (Int,String,String)
type Stack = String
data Result = Accept | Reject deriving (Show, Eq)

run :: PDA -> String -> Result
run (startState, accepting, transitions) test = next startState (startState, accepting, transitions) transitions test "/"



next :: Int -> PDA -> [Transition] -> String -> Stack -> Result
next startState pda [] [] (s:[])
   | elem startState (accept pda) = Accept
   | otherwise = Reject
next startState pda (((_, character, popped),(newStart,pushed)):trans) [] (s:[])
   | character == "" && ((next newStart pda (tran pda newStart) [] (push pushed (pop popped (s:[])))) == Accept) = Accept
   | otherwise = next startState pda trans [] (s:[])
next startState pda _ [] _ = Reject
next _ _ [] _ _ = Reject
next _ _ _ _ [] = Reject
next startState pda (((_, character, popped),(newStart, pushed)):trans) (i:s) stack
   | ((character == "") && ((next newStart pda (tran pda newStart) (i:s) (push pushed (pop popped stack)))== Accept)) = Accept
   | ((character == [i]) && ((next newStart pda (tran pda newStart) s (push pushed (pop popped stack)))== Accept)) = Accept
   | otherwise = next startState pda trans (i:s) stack



accept :: PDA -> [Int]
accept (_, l, _) = l

tran :: PDA -> Int -> [Transition]
tran (_,_,[]) _ = []
tran (_, _, ((state, character, popped),(newStart, pushed)):trans) startState
   | state == startState = ((state, character, popped),(newStart, pushed)) : tran (0,[0],trans) startState
   | otherwise = tran (0, [0], trans) startState

push :: String -> Stack -> Stack
push _ [] = []
push [] stack = stack
push n stack = n ++ stack

pop :: String -> Stack -> Stack
pop [] stack = stack
pop c (s:stack)
   | c == [s] = stack
   | otherwise = []