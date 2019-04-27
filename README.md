# Rspeer, but in python/golang/javascript/elm/etc.

This is an experimental project so that any language can run the rspeer api. See `client/python/main.py` for an example.

## Why

Rspeer - and runescape botting in general - is often someone's first experience with code. I have no problem with Java, but setting up the jars + dependencies correctly can be a challenge for newcomers.

The first clients I'm focusing on are python and a web ui interface using the Blockly framework (think of Scratch, but with runescape specific blocks).  This is to ease in newcomers into development.

People can write something like

```
import Movement

Movement.toggle_run(True)
```

and have that be a complete program!

Also, Mad really likes golang apparently, so he can write his own golang client.

## How the sausage gets made

There is a standard java script that starts a grpc server. See proto/activity.proto for the schema.

Any client can then send rpc requests to this local server, which will respond just as the standard java rspeer api would.

## Integration into official rspeer client

Wouldn't it be nice if the official client did this, and scripts could be written using a variety of SDKs in officially/unofficially supported languages? I guess.

Mad expressed interest in this, but mantaining additional sdks for each rspeer release would be a fair amount of extra work.
