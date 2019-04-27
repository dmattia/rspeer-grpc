# Custom rspeer sdk in python (not fully built out yet)
import Movement
import Players
from Position import Position

# You can use any python lib, stdlib or third party :)
import math
import time

def sleep_until(func):
    """ TODO: Move to common lib
    """
    while not func():
        time.sleep(1)

def distance(pos1, pos2):
    """ TODO: Move to common lib
    """
    x_diff = (pos1.world_x - pos2.world_x) ** 2
    y_diff = (pos1.world_y - pos2.world_y) ** 2
    return math.sqrt(x_diff + y_diff)

def walk_all_the_way_to(pos):
    while distance(Players.get_local().position, pos) > 10:
        if Movement.get_run_energy() > 30 and not Movement.is_run_enabled():
            Movement.toggle_run(True)

        Movement.walk_to(pos)
        time.sleep(1)
        sleep_until(lambda: not Players.get_local().is_moving)

# Walk in square around GE, repeatedly
while True:
    walk_all_the_way_to(Position(world_x=3144, world_y=3513)) # NW GE
    walk_all_the_way_to(Position(world_x=3143, world_y=3471)) # SW GE
    walk_all_the_way_to(Position(world_x=3184, world_y=3470)) # SE GE
    walk_all_the_way_to(Position(world_x=3187, world_y=3513)) # N# GE

