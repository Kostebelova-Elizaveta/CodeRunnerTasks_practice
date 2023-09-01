package io;

import org.junit.jupiter.api.*;
import ru.etu.graph.DirectedGraphList;
import ru.etu.graph.Graph;
import ru.etu.graph.GraphList;
import ru.etu.io.IOGraph;

import java.io.File;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IOTest {

    private IOGraph saver;
    private Graph simple;
    private Graph simpleDirected;
    private Graph complex;
    private Graph complexDirected;
    private Graph simpleTest;
    private Graph simpleDirectedTest;
    private Graph complexTest;
    private Graph complexDirectedTest;

    @BeforeEach
    void before(){
        simple = new GraphList();
        simple.insertVertex("A");
        simple.insertVertex("B");
        simple.insertVertex("C");
        simple.insertVertex("D");
        simple.insertVertex("E");
        simple.insertEdge("B", "A", 1);
        simple.insertEdge("C", "B", 1);
        simple.insertEdge("D", "C", 1);
        simple.insertEdge("E", "D", 1);
        saver = new IOGraph();
        /*try {
            saver.saveGraph("test_simple.txt", simple);
            saver.saveGraph("test_simple_another_type.wtf", simple);
            saver.saveGraph("new_dir"+ File.separator +"test_simple_another_dir.txt", simple);
            saver.saveGraph("test_simple_кириллица.txt", simple);
            saver.saveGraph(".."+ File.separator +"test_simple_another_dir2.wtf", simple);
            saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_simple_abs_dir.txt", simple);
        } catch (IOException ex){
            System.out.println("Cannot create file "+ex.getLocalizedMessage());
        }*/
        simpleDirected = new DirectedGraphList();
        simpleDirected.insertVertex("A");
        simpleDirected.insertVertex("B");
        simpleDirected.insertVertex("C");
        simpleDirected.insertVertex("D");
        simpleDirected.insertVertex("E");
        simpleDirected.insertEdge("B", "A", 1);
        simpleDirected.insertEdge("C", "B", 1);
        simpleDirected.insertEdge("D", "C", 1);
        simpleDirected.insertEdge("E", "D", 1);
        /*try {
            saver.saveGraph("test_simpledirected.txt", simpleDirected);
            saver.saveGraph("test_simpledirected_another_type.wtf", simpleDirected);
            saver.saveGraph("new_dir"+ File.separator +"test_simpledirected_another_dir.txt", simpleDirected);
            saver.saveGraph("test_simpledirected_кириллица.txt", simpleDirected);
            saver.saveGraph(".."+ File.separator +"test_simpledirected_another_dir2.wtf", simpleDirected);
            saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_simpledirected_abs_dir.txt", simpleDirected);
        } catch (IOException ex){
            System.out.println("Cannot create file "+ex.getLocalizedMessage());
        }*/
        complex = new GraphList();
        complex.insertVertex("A");
        complex.insertVertex("B1");
        complex.insertVertex("B2");
        complex.insertVertex("C1");
        complex.insertVertex("C2");
        complex.insertVertex("D1");
        complex.insertVertex("D2");
        complex.insertVertex("E");
        complex.insertEdge("B1", "A", 10);
        complex.insertEdge("B2", "A", 1);
        complex.insertEdge("C1", "B1", 10);
        complex.insertEdge("C2", "B2", 1);
        complex.insertEdge("D1", "C1", 10);
        complex.insertEdge("D2", "C2", 1);
        complex.insertEdge("E", "D1", 10);
        complex.insertEdge("E", "D2", 50);
        /*try {
            saver.saveGraph("test_complex.txt", complex);
            saver.saveGraph("test_complex_another_type.wtf", complex);
            saver.saveGraph("new_dir"+ File.separator +"test_complex_another_dir.txt", complex);
            saver.saveGraph("test_complex_кириллица.txt", complex);
            saver.saveGraph(".."+ File.separator +"test_complex_another_dir2.wtf", complex);
            saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_complex_abs_dir.txt", complex);
        } catch (IOException ex){
            System.out.println("Cannot create file "+ex.getLocalizedMessage());
        }*/
        complexDirected = new DirectedGraphList();
        complexDirected.insertVertex("A");
        complexDirected.insertVertex("B1");
        complexDirected.insertVertex("B2");
        complexDirected.insertVertex("C1");
        complexDirected.insertVertex("C2");
        complexDirected.insertVertex("D1");
        complexDirected.insertVertex("D2");
        complexDirected.insertVertex("E");
        complexDirected.insertEdge("B1", "A", 10);
        complexDirected.insertEdge("B2", "A", 1);
        complexDirected.insertEdge("C1", "B1", 10);
        complexDirected.insertEdge("C2", "B2", 1);
        complexDirected.insertEdge("D1", "C1", 10);
        complexDirected.insertEdge("D2", "C2", 1);
        complexDirected.insertEdge("E", "D1", 10);
        complexDirected.insertEdge("E", "D2", 50);
        /*try {
            saver.saveGraph("test_complexdirected.txt", complexDirected);
            saver.saveGraph("test_complexdirected_another_type.wtf", complexDirected);
            saver.saveGraph("new_dir"+ File.separator +"test_complexdirected_another_dir.txt", complexDirected);
            saver.saveGraph("test_complexdirected_кириллица.txt", complexDirected);
            saver.saveGraph(".."+ File.separator +"test_complexdirected_another_dir2.wtf", complexDirected);
            saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_complexdirected_abs_dir.txt", complexDirected);
        } catch (IOException ex){
            System.out.println("Cannot create file "+ex.getLocalizedMessage());
        }*/
    }

    @Test
    @Order(1)
    void testSave_Simple(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Simple.txt", simple);});
    }

    @Test
    @Order(2)
    void testSave_Simple_another_type(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Simple_another_type.wtf", simple);});
    }

    @Test
    @Order(3)
    void testSave_Simple_another_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("new_dir"+ File.separator +"test_Simple_another_dir.txt", simple);});
    }

    @Test
    @Order(4)
    void testSave_Simple_another_lang(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Simple_кириллица.txt", simple);});
    }

    @Test
    @Order(5)
    void testSave_Simple_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph(".."+ File.separator +"test_Simple_another_dir2.wtf", simple);});
    }

    @Test
    @Order(6)
    void testSave_Simple_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_Simple_abs_dir.txt", simple);});
    }

    @Test
    @Order(7)
    void testSave_SimpleDirected(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_SimpleDirected.txt", simpleDirected);});
    }

    @Test
    @Order(8)
    void testSave_SimpleDirected_another_type(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_SimpleDirected_another_type.wtf", simpleDirected);});
    }

    @Test
    @Order(9)
    void testSave_SimpleDirected_another_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("new_dir"+ File.separator +"test_SimpleDirected_another_dir.txt", simpleDirected);});
    }

    @Test
    @Order(10)
    void testSave_SimpleDirected_another_lang(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_SimpleDirected_кириллица.txt", simpleDirected);});
    }

    @Test
    @Order(11)
    void testSave_SimpleDirected_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph(".."+ File.separator +"test_Simple_anotherDirected_dir2.wtf", simpleDirected);});
    }

    @Test
    @Order(12)
    void testSave_SimpleDirected_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_SimpleDirected_abs_dir.txt", simpleDirected);});
    }

    @Test
    @Order(13)
    void testSave_Complex(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Complex.txt", complex);});
    }

    @Test
    @Order(14)
    void testSave_Complex_another_type(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Complex_another_type.wtf", complex);});
    }

    @Test
    @Order(15)
    void testSave_Complex_another_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("new_dir"+ File.separator +"test_Complex_another_dir.txt", complex);});
    }

    @Test
    @Order(16)
    void testSave_Complex_another_lang(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_Complex_кириллица.txt", complex);});
    }

    @Test
    @Order(17)
    void testSave_Complex_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph(".."+ File.separator +"test_Complex_another_dir2.wtf", complex);});
    }

    @Test
    @Order(18)
    void testSave_Complex_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_Complex_abs_dir.txt", complex);});
    }

    @Test
    @Order(19)
    void testSave_ComplexDirected(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_ComplexDirected.txt", complexDirected);});
    }

    @Test
    @Order(20)
    void testSave_ComplexDirected_another_type(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_ComplexDirected_another_type.wtf", complexDirected);});
    }

    @Test
    @Order(21)
    void testSave_ComplexDirected_another_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("new_dir"+ File.separator +"test_ComplexDirected_another_dir.txt", complexDirected);});
    }

    @Test
    @Order(22)
    void testSave_ComplexDirected_another_lang(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("test_ComplexDirected_кириллица.txt", complexDirected);});
    }

    @Test
    @Order(23)
    void testSave_ComplexDirected_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph(".."+ File.separator +"test_ComplexDirected_another_dir2.wtf", complexDirected);});
    }

    @Test
    @Order(24)
    void testSave_ComplexDirected_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { saver.saveGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_ComplexDirected_abs_dir.txt", complexDirected);});
    }

    @Test
    @Order(25)
    void testNotFound(){
        Assertions.assertThrows(IOException.class,() -> { saver.loadGraph("test_404.txt");});
    }

    @Test
    @Order(26)
    void testOpen_Simple(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph("test_Simple.txt");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    @Test
    @Order(27)
    void testOpen_Simple_another_type(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph("test_Simple_another_type.wtf");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    @Test
    @Order(28)
    void testOpen_Simple_another_dir(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph("new_dir"+ File.separator +"test_Simple_another_dir.txt");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    @Test
    @Order(29)
    void testOpen_Simple_another_lang(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph("test_Simple_кириллица.txt");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    @Test
    @Order(30)
    void testOpen_Simple_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph(".."+ File.separator +"test_Simple_another_dir2.wtf");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    @Test
    @Order(31)
    void testOpen_Simple_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { simpleTest = saver.loadGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_Simple_abs_dir.txt");});
        Assertions.assertEquals(simpleTest.toString(), simple.toString());
    }

    //

    @Test
    @Order(32)
    void testOpen_Complex(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph("test_Complex.txt");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    @Test
    @Order(33)
    void testOpen_Complex_another_type(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph("test_Complex_another_type.wtf");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    @Test
    @Order(34)
    void testOpen_Complex_another_dir(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph("new_dir"+ File.separator +"test_Complex_another_dir.txt");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    @Test
    @Order(35)
    void testOpen_Complex_another_lang(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph("test_Complex_кириллица.txt");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    @Test
    @Order(36)
    void testOpen_Complex_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph(".."+ File.separator +"test_Complex_another_dir2.wtf");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    @Test
    @Order(37)
    void testOpen_Complex_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { complexTest = saver.loadGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_Complex_abs_dir.txt");});
        Assertions.assertEquals(complexTest.toString(), complex.toString());
    }

    //

    @Test
    @Order(38)
    void testOpen_SimpleDirected(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph("test_SimpleDirected.txt");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    @Test
    @Order(39)
    void testOpen_SimpleDirected_another_type(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph("test_SimpleDirected_another_type.wtf");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    @Test
    @Order(40)
    void testOpen_SimpleDirected_another_dir(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph("new_dir"+ File.separator +"test_SimpleDirected_another_dir.txt");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    @Test
    @Order(41)
    void testOpen_SimpleDirected_another_lang(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph("test_SimpleDirected_кириллица.txt");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    @Test
    @Order(42)
    void testOpen_SimpleDirected_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph(".."+ File.separator +"test_Simple_anotherDirected_dir2.wtf");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    @Test
    @Order(43)
    void testOpen_SimpleDirected_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { simpleDirectedTest = saver.loadGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_SimpleDirected_abs_dir.txt");});
        Assertions.assertEquals(simpleDirectedTest.toString(), simpleDirected.toString());
    }

    //

    @Test
    @Order(44)
    void testOpen_ComplexDirected(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph("test_ComplexDirected.txt");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @Test
    @Order(45)
    void testOpen_ComplexDirected_another_type(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph("test_ComplexDirected_another_type.wtf");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @Test
    @Order(46)
    void testOpen_ComplexDirected_another_dir(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph("new_dir"+ File.separator +"test_ComplexDirected_another_dir.txt");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @Test
    @Order(47)
    void testOpen_ComplexDirected_another_lang(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph("test_ComplexDirected_кириллица.txt");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @Test
    @Order(48)
    void testOpen_ComplexDirected_another_dir2(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph(".."+ File.separator +"test_ComplexDirected_another_dir2.wtf");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @Test
    @Order(49)
    void testOpen_ComplexDirected_abs_dir(){
        Assertions.assertDoesNotThrow(() -> { complexDirectedTest = saver.loadGraph("C:"+ File.separator +"delete_me"+ File.separator +"test_ComplexDirected_abs_dir.txt");});
        Assertions.assertEquals(complexDirectedTest.toString(), complexDirected.toString());
    }

    @AfterAll
    static void testClearGarbage(){
        try {
            if(!new File("test_Simple.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Simple.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_Simple_another_type.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Simple_another_type.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("new_dir"+ File.separator +"test_Simple_another_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"new_dir"+ File.separator +"test_Simple_another_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_Simple_кириллица.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Simple_кириллица.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File(".."+ File.separator +"test_Simple_another_dir2.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+".."+ File.separator +"test_Simple_another_dir2.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("C:"+ File.separator +"delete_me"+ File.separator +"test_Simple_abs_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"C:"+ File.separator +"delete_me"+ File.separator +"test_Simple_abs_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_SimpleDirected.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_SimpleDirected.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_SimpleDirected_another_type.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_SimpleDirected_another_type.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("new_dir"+ File.separator +"test_SimpleDirected_another_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"new_dir"+ File.separator +"test_SimpleDirected_another_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_SimpleDirected_кириллица.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_SimpleDirected_кириллица.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File(".."+ File.separator +"test_Simple_anotherDirected_dir2.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+".."+ File.separator +"test_Simple_anotherDirected_dir2.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("C:"+ File.separator +"delete_me"+ File.separator +"test_SimpleDirected_abs_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"C:"+ File.separator +"delete_me"+ File.separator +"test_SimpleDirected_abs_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_Complex.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Complex.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_Complex_another_type.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Complex_another_type.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("new_dir"+ File.separator +"test_Complex_another_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"new_dir"+ File.separator +"test_Complex_another_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_Complex_кириллица.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_Complex_кириллица.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File(".."+ File.separator +"test_Complex_another_dir2.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+".."+ File.separator +"test_Complex_another_dir2.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("C:"+ File.separator +"delete_me"+ File.separator +"test_Complex_abs_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"C:"+ File.separator +"delete_me"+ File.separator +"test_Complex_abs_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_ComplexDirected.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_ComplexDirected.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_ComplexDirected_another_type.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_ComplexDirected_another_type.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("new_dir"+ File.separator +"test_ComplexDirected_another_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"new_dir"+ File.separator +"test_ComplexDirected_another_dir.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File("test_ComplexDirected_кириллица.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"test_ComplexDirected_кириллица.txt"+"! Please, delete it manually.");
        }
        try {
            if(!new File(".."+ File.separator +"test_ComplexDirected_another_dir2.wtf").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+".."+ File.separator +"test_ComplexDirected_another_dir2.wtf"+"! Please, delete it manually.");
        }
        try {
            if(!new File("C:"+ File.separator +"delete_me"+ File.separator +"test_ComplexDirected_abs_dir.txt").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete "+"C:"+ File.separator +"delete_me"+ File.separator +"test_ComplexDirected_abs_dir.txt"+"! Please, delete it manually.");
        }
        try{
            if(!new File("new_dir").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete dir "+"new_dir"+"! Please, delete it manually.");
        }
        try{
            if(!new File("C:"+ File.separator +"delete_me").delete()){
                throw new Exception();
            }
        } catch (Exception ex){
            System.out.println("Cannot delete dir "+"C:"+ File.separator +"delete_me"+"! Please, delete it manually.");
        }
    }
}
