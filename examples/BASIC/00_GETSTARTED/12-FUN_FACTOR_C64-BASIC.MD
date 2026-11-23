## BASIC-58
```
10 PRINT "COOL"
20 RANDOMIZE
30 LET FUNFACT = INT(RND(1) * 100)
40 IF FUNFACT <= 90 THEN 30
50 PRINT "C64 FUNFACTOR: "; FUNFACT; " %"
60 PRINT "ENJOY"
70 END
```

## C64 BASIC V2
```
10 PRINT "COOL"
20 R = RND(-TI)
30 LET FU = INT(RND(1) * 100)
40 IF FU <= 90 THEN 30
50 PRINT "C64 FUNFACTOR: "; FU; " %"
60 PRINT "ENJOY"
70 END
```

## Explain
The logic is perfectly suitable for Commodore 64 BASIC V2, but two changes are needed.
1. RANDOMIZE is not a C64 BASIC V2 command. Use R = RND(-TI) to seed the random generator.
2. C64 BASIC V2 variable names are effectively limited to two significant characters. FUNFACT would be treated as FU.

C64-compatible version
```
20 R = RND(-TI)
```
This is a classic Commodore 64 BASIC V2 trick to initialize (seed) the random number generator.

Let's break it down:
- TI is a built-in C64 variable containing the current time in jiffies (1/60 of a second).
- RND() is the random-number function.
- RND(-n) with a negative argument initializes the random-number generator using that value as its seed.
- R = stores the returned value in R (the actual random value isn't important here).
So:
```
20 R = RND(-TI)
```
means: use the current time as the seed, making the random sequence different each time the program starts.

**Why use -TI?**  
The negative argument tells C64 BASIC V2 to reseed the generator. Using TI makes the seed depend on when the program is started.

And an interesting contrast:
- BASIC-58: RANDOMIZE
- C64 BASIC V2: RND(-TI)

Same purpose, different BASIC dialects! 😊