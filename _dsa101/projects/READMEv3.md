# Project Penumbra: A Vision Document

Let's build a game.

This document isn't just a plan; it's the story of a game we're going to make together. It's called Project Penumbra.

Penumbra is that strange, beautiful light you see during an eclipse. It's the gray space between total shadow and full sun. It's not quite dark, not quite light. That's our game world—a place of forgotten dungeons, half-remembered legends, and secrets hiding just out of the torchlight. You don't play as a legendary hero. You play as someone brave enough to step into the gray and see what's there.
The World & The Characters

The world is broken, overgrown, and full of old magic. Deep underground, labyrinths shift and change. No one knows who built them.

Our guides into this world are three adventurers, each seeing the Penumbra differently:

    Ali is the scout. Quick, curious, and always moving. They see the paths, the traps, the ways in and out. The dungeon is a puzzle to be navigated.

    Mayowa is the scholar. Thoughtful, steady, and keen-eyed. They see the history in the stones, the meaning in the symbols. The dungeon is a mystery to be understood.

    Pranaya is the keeper. Resourceful, careful, and prepared. They manage what the group finds, making sure nothing is wasted and every tool is ready. The dungeon is a challenge to be outfitted.

You'll get to walk in their shoes. The goal isn't to conquer the dark with overwhelming force, but to explore it with smart moves, sharp thinking, and the supplies you can carry.
What We're Actually Building

In plain terms, we're building a top-down, 2D dungeon crawler. Imagine a simple, pixel-art world you view from above. You explore rooms and corridors, find keys for locked doors, avoid or outsmart creatures, and try to find the way to the next level.

The twist? The dungeon layout is different every single time you play. We're going to teach the computer how to build these mazes for us. One day you might get a simple layout, the next day a complex web of tunnels. This keeps the game fresh and makes every run a new adventure.
The Realistic Goal

Let's be upfront: we are not a professional studio. We are not making the next huge indie hit. Trying to do that would burn us out and leave us with nothing but messy code.

Our real, honest goal is to end up with a single, complete, working game on our computers. A game that starts, runs without crashing, has a clear beginning and end, and is actually fun for a few minutes. If we can package it up and give it to a friend to try, that's a massive win.

Everything we do is in service of that goal. We start with a square moving on a screen. Then we add walls. Then we make a room. Then two rooms. Step by step, playable every day.
The Plan: Our Map Through the Dungeon

We have a clear map for the next several weeks. Each week, we focus on one big thing that makes the game more real.

### Week 1: The Hollow World (Dec 22-28)
We build the empty stage. This is all about making the dungeon itself. By the end of the week, we'll have a program that creates a random, walkable maze every time you run it. Our character can walk through it. That's it. That's our victory. The core idea here is treating the dungeon like a graph—a network of paths—which is a fundamental way computers understand connections.

### Week 2: The Key and The Door (Dec 29 - Jan 4)
We put things in the world. We'll code a simple inventory so our adventurer can pick up a key. We'll place doors that only open with that key. Suddenly, it's not just a maze—it's a puzzle. You need to find the right item to progress. This teaches us about data management, like using the right structure to track what items you're carrying.

### Week 3: The Pursuit (Jan 5-11)
We add a heartbeat of danger. We'll create a simple creature that lives in the dungeon. It won't just sit there; it will try to find you, navigating the maze we built in Week 1. This is where the world feels alive. Making this creature "smart" enough to chase you introduces classic search algorithms, the same kind used for navigation in all sorts of software.

### Week 4: The Complete Loop (Jan 12-18)
We make it feel like a real game. We add a health bar, so the creature from Week 3 is a real threat. We add a way to win (finding the exit) and a way to lose (running out of health). We might add a simple title screen and a "Game Over" screen. By Friday, we should have a file we can double-click—a complete, if short, experience.

### Week 5 & Beyond: Making it Ours
Once we have the complete loop, the real fun begins. This is where we add the flavor. Maybe we add different types of keys and doors. Maybe the scholar can find scrolls that reveal parts of the map. Maybe the scout can move faster. This is where our game stops being a generic dungeon crawl and starts becoming Penumbra.
The Skills We'll Find in the Dark

While we're building this world, we're going to learn by doing. We won't just study graphs and algorithms from a textbook; we'll use them to bring a dungeon to life. We won't just talk about code architecture; we'll build it piece by piece to keep our game from collapsing. This project is our practice ground. The goal is to finish with stronger, more confident coding instincts and a concrete thing we made to show for it.

This is Project Penumbra. It's an adventure in gray. It's about finding what you can build when you start with a single step into the unknown.

Let's begin.
