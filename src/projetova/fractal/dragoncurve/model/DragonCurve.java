package projetova.fractal.dragoncurve.model;

import java.util.List;
import java.util.LinkedList;
import org.javatuples.Pair;
import projetova.utils.ComplexNumber;
import projetova.utils.Couple;

public class DragonCurve {   
    int iteration = 0; 
    List<Pair<Couple<ComplexNumber>, Integer>> list;
    
    public DragonCurve() {
        list = new LinkedList<>();
    }
    
    public void generateCurve(int iterations) {
        
        if(list.isEmpty()) {
            Couple<ComplexNumber> initial = new Couple(new ComplexNumber(0, 0), new ComplexNumber(0, 1));
            this.add(new Pair<>(initial, this.iteration));
        }
        
        for(int i = 0; i < iterations; i++)
            this.nextIteration();
    }
    
    public void nextIteration() {
        this.iteration++;
        List<Pair<Couple<ComplexNumber>, Integer>> actualCenario = new LinkedList<>(this.list);
        for(int i = actualCenario.size()-1; i >= 0; i--) {
            Couple<ComplexNumber> pairToRotate = actualCenario.get(i).getValue0();
            Couple<ComplexNumber> lastPair = list.get(list.size()-1).getValue0();
            
            Couple<ComplexNumber> newPair = new Couple<> (
                                              lastPair.y,
                                              ComplexNumber.rotate(pairToRotate)
                                                           .put(lastPair.y)
                                          );
            
            Pair<Couple<ComplexNumber>, Integer> newElement = 
                    new Pair<>(newPair, this.iteration);
            
            this.add(newElement);
        }
    }
    
    public void add(Pair<Couple<ComplexNumber>, Integer> next) {
        this.list.add(next);
    }
    
    public LinkedList<Pair<ComplexNumber, Integer>> getResumedColorizedList() {
        LinkedList<Pair<ComplexNumber, Integer>> resumedColorizedList =
                new LinkedList<>();
        
        this.getList().forEach(
            (pair) -> {
                resumedColorizedList.add(
                    new Pair<>(pair.getValue0().y, pair.getValue1())
            );
        });
        
        return resumedColorizedList;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }
    
    public LinkedList<Pair<Couple<ComplexNumber>, Integer>> getList() {
        return new LinkedList<>(list);
    }
    
    public LinkedList<ComplexNumber> getResumedList() {
        LinkedList<ComplexNumber> resumedList = new LinkedList<>();
        
        resumedList.add(new ComplexNumber(0, 0));
        
        this.getList().forEach((pair) -> {
            resumedList.add(pair.getValue0().y);
        });
        
        return resumedList;
    }
}   
