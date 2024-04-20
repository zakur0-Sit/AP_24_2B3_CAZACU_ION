package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Player extends Thread
{
    String name;
    private final Bag bag;
    private final List<Token> tokensList = new ArrayList<>();
    private final List<Token> sequence = new ArrayList<>();
    private final Map<Integer, List<Token>> map = new TreeMap<>();
    private final List<Token> possibleSequence = new ArrayList<>();
    private List<Token> goodSequence = new ArrayList<>();

    public Player(String name, Bag bag)
    {
        this.name = name;
        this.bag = bag;
    }

    @Override
    public void run()
    {
        try {
            for (int i = 0; i < bag.tokens.size(); i++) {
                synchronized (bag) {
                    System.out.print(name + " got token : ");
                    try {
                        Token token = bag.extractToken();
                        tokensList.add(token);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while extracting token: " + e.getMessage());
                        Thread.currentThread().interrupt();
                        return;
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while sleeping: " + e.getMessage());
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (bag.tokens.isEmpty())
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTokensList()
    {
        System.out.println(name + " has tokens: " + tokensList + " and has finished the game");
    }

    public void gameLogic()
    {
        int count = 0;
        boolean jump = false;
        for(int i = 0; i < tokensList.size(); i++)
        {
            for(int j = 0; j < tokensList.size(); j++)
            {
                if(tokensList.get(i) == tokensList.get(j))
                {
                    continue;
                }
                if((tokensList.get(i).getFirst() == tokensList.get(j).getSecond() || tokensList.get(i).getSecond() == tokensList.get(j).getFirst()))
                {
                    for(List<Token> list : map.values())
                    {
                        if(list.contains(tokensList.get(i)) && list.contains(tokensList.get(j)))
                        {
                            jump = true;
                            break;
                        }
                    }
                    if(jump)
                    {
                        jump = false;
                        continue;
                    }
                    if(tokensList.get(i).getFirst() == tokensList.get(j).getSecond() && tokensList.get(i).getSecond() == tokensList.get(j).getFirst()) {
                        sequence.add(tokensList.get(i));
                        sequence.add(tokensList.get(j));
                        map.put(count, new ArrayList<>(sequence));
                        if(possibleSequence.size() < sequence.size())
                        {
                            possibleSequence.add(tokensList.get(i));
                            possibleSequence.add(tokensList.get(j));
                        }
                        count++;
                        sequence.clear();
                    }
                    if(tokensList.get(i).getFirst() == tokensList.get(j).getSecond())
                    {
                        sequence.add(tokensList.get(j));
                        sequence.add(tokensList.get(i));
                    }else
                    {
                        sequence.add(tokensList.get(i));
                        sequence.add(tokensList.get(j));
                    }
                    map.put(count, new ArrayList<>(sequence));
                    count++;
                    sequence.clear();
                }
            }
        }
        System.out.println(name + " first iteration has sequences of tokens: ");
        for (Map.Entry<Integer, List<Token>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        boolean ok = true;
        for(int i = 0; i < map.size(); i++)
        {
            List<Token> list = tokensList;
            ok = false;
            while (!ok)
            {
                for(int j = 0; j < tokensList.size(); j++)
                {
                    for (List<Token> sequence : map.values()) {
                        for (Token tokenInSequence : sequence) {
                            if (tokenInSequence.equals(list.get(j))) {
                                jump = true;
                                break;
                            }
                        }
                        break;
                    }
                    if(jump)
                    {
                        jump = false;
                        continue;
                    }
                    if(list.get(j).getFirst() == map.get(i).getLast().getSecond())
                    {
                        map.get(i).addLast(list.get(j));
                    }
                    else if(list.get(j).getSecond() == map.get(i).getFirst().getFirst())
                    {
                        map.get(i).addFirst(list.get(j));
                    }
                    else
                    {
                        ok = true;
                    }

                    if(map.get(i).getFirst().getFirst() == map.get(i).getLast().getSecond() && possibleSequence.size() < map.get(i).size())
                    {
                        possibleSequence.clear();
                        possibleSequence.addAll(map.get(i));
                        goodSequence.clear();
                        goodSequence.addAll(possibleSequence);
                    }

                }
            }

            possibleSequence.clear();
            possibleSequence.addAll(map.get(i));

            for(int j = 0; j < map.get(i).size(); j++)
            {
                for(int k = 0; k < map.get(i).size(); k++)
                {
                    if(possibleSequence.get(j).getFirst() == possibleSequence.get(k).getSecond() && (k-j +1) > goodSequence.size())
                    {
                        goodSequence.clear();
                        for(int l = j; l <= k; l++)
                        {
                            goodSequence.add(possibleSequence.get(l));
                        }
                    }
                }
            }

        }
        System.out.println("\n\n" + name + " has sequences of tokens: ");
        for (Map.Entry<Integer, List<Token>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n\n" + name + " has the longest COMPLETE sequence of tokens: " + goodSequence + " with length: " + goodSequence.size());
    }

    public int getSequenceLength()
    {
        return goodSequence.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}