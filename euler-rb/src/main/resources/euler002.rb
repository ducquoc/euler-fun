#### Finds the sum of all even values in Fibonacci sequence which < 4000000

def solve_me(obj, *args)
  result = doLessEngineering
  puts result
end

def doStraightImmediately # S.I
  sum = 0
  firstFibo = 1
  secondFibo = 2

  while firstFibo < 4_000_000
    sum += firstFibo  if firstFibo.even?
    firstFibo , secondFibo = secondFibo , firstFibo + secondFibo
  end

  return sum
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
