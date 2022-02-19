import java.util.ArrayList;
import java.util.List;

public class Interview { // Каждый из блоков кода является реализацией принципа инкапсуляции

    public static void main(String[] args) {
        Employer employer = new Employer();
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new SelfLearner("John", "Self-learner"));
        candidates.add(new Graduated("Harry", "Experienced"));
        candidates.add(new SelfLearner("Steve", "Self-learner"));
        candidates.add(new SelfLearner("George", "Self-learner"));
        candidates.add(new Graduated("James", "Experienced"));
        candidates.add(new Graduated("William", "Experienced"));
        candidates.add(new SelfLearner("Viktor", "Self-learner"));
        candidates.add(new Graduated("Michael", "Experienced"));
        candidates.add(new SelfLearner("Chris", "Self-learner"));
        candidates.add(new Graduated("David", "Experienced"));
        for(Candidate candidate: candidates) {
            employer.hello();
            candidate.hello(); // Полиморфизм. Один интерфейс - несколько реализаций
            candidate.describeExperience(); // Полиморфизм
        }
    }
}
abstract class Candidate implements Experience { // Наследование.
    String name;
    String experience;

    Candidate(String name, String exp) {
        this.name = name;
        experience = exp;
    }


    public void hello() {
        System.out.print("Hi, my name is " + name + ". ");
    }
}
class SelfLearner extends Candidate{ // Наследование сабклассом переменных и методов суперкласса.
    public SelfLearner(String name, String exp) {
        super(name, exp);
    }
    public void describeExperience() { // Полиморфизм и наследование метода выполняемого суперклассом.
        System.out.println("Ive been learning Java by myself, nobody examined how thorough is my knowledge and how good is my code.");
        System.out.println();
    }
}
class Graduated extends Candidate { // Наследование сабклассом переменных и методов суперкласса.
    public Graduated(String name, String exp) {
        super(name, exp);
    }
    public void describeExperience() { // Полиморфизм и наследование метода выполняемого суперклассом.
        System.out.println("I passed successfully getJavaJob exams and code reviews.");
        System.out.println();
    }
}
class Employer {
    public void hello() {
        System.out.println("Hi! Introduce yourself");
    }
}
interface Experience { // Наследование, полиморфизм. Интерфейс не описывает тело метода,
    void describeExperience(); // это по-своему делает каждый из классов, который наследует этот метод.
    }