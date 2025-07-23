# StaffHelper

🚧 **StaffHelper** is a modular developer toolkit for Minecraft servers, focused on low-level packet inspection, crash testing, and debugging utilities. Built with **PacketEvents**, it provides fine-grained control over both clientbound and serverbound communication.

## ✨ Features

- 📦 **Packet Interception & Injection**  
  Intercept and modify C2S/S2C packets using PacketEvents with minimal overhead.

- 💥 **Crash Simulation Tools**  
  Simulate server crashes with various packet-based methods:  
  - `PARTICLE` overload  
  - `EXPLOSION` spam  
  - `INFINITE_POSITION`  
  - `DESTROY_PLAYER_ENTITY_A/B`  
  - `PAYLOAD_OVERFLOW`  
  - And more...

- 🧱 **Modular Architecture**  
  Easily add new `CrashMethod`, `TrickMethod`, or packet hooks by extending abstract classes.

## 🧩 Dependencies

- [PacketEvents](https://github.com/retrooper/packetevents) (v2.x or above recommended)
- Minecraft 1.19 – 1.20.4 supported  
  *(Version-specific mappings may be needed)*

## 🤝 Contributing

I warmly welcome pull requests!  
Whether it's a new crash method, a weird trick, or just a tiny fix — contributions are appreciated.

Open an issue or send a PR anytime.

