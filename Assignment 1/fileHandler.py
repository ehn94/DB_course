import sys

db = open('db.txt', 'w')

param1 = sys.argv[1]
param2 = sys.argv[2]

def write_to_file(key=param1, val=param2):
    db.write("{} {}".format(key, val))
    pair = key, val
    print pair
    db.close

if __name__ == "__main__":
    write_to_file()