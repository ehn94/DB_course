import sys

db = open('db.txt', 'w')

param1 = sys.argv[1]
param2 = sys.argv[2]

def write_to_file(key=param1, val=param2):
    pair =  "%s:%s" % (key, val)
    db.write(enc(pair) + '\n')
    db.close

with open('db.txt', "rb") as binary_file:
    data = binary_file.read()
    print(data)

def enc(string):
    return "".join([format(ord(char), '#010b')[2:] for char in string])

if __name__ == "__main__":
    write_to_file()