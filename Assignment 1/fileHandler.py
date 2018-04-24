import sys

db = 'db.txt'

param1 = sys.argv[1]
param2 = sys.argv[2]

def write_to_file(key=param1, val=param2):
    f = open(db,'a')
    pair =  "%s:%s" % (key, val)
    f.write(enc(pair) + '\n')
    f.close() 

with open('db.txt', "rb") as binary_file:
    data = binary_file.read()
    print(data)

def enc(string):
    return "".join([format(ord(char), '#010b')[2:] for char in string])

if __name__ == "__main__":
    write_to_file()