#### Finds a number that you can divide by 1..20

def solve_me(obj, *args)
  result = doLessEngineering
  puts result
end

def doStraightImmediately # S.I
  till = 20
  primes = [2,3,5,7,11,13,17,19]

  factors = primes.map{ |f|
    f > (limit ||= till**0.5) ? 1 : ( Math.log(till)/Math.log(f) ).to_i
  }

  number = 1
  p = primes.each
  f = factors.each

  loop{ number *= p.next**f.next }
  return number
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
