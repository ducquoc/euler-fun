#### Finds the difference: square of sum minus sum of squares of 1..100

def solve_me(obj, *args)
  result = doLessEngineering
  puts result
end

def doStraightImmediately # S.I
  max = 100
  sum_of_squares = (1..max).inject{ |acc, ele| 
    acc + ele**2
  }
  square_of_sum  = (1..max).inject{ |acc, ele| 
    acc + ele
  }**2

  return square_of_sum - sum_of_squares
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
