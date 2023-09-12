package ayedd.examenFinal;

import java.time.Instant;
import java.time.Duration;
import edu.princeton.cs.algs4.Out;

import java.util.Random;
import java.util.Arrays;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import org.junit.contrib.java.lang.system.ExpectedSystemExit ;
import org.junit.Rule;


import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.powermock.api.mockito.PowerMockito.*;



@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "ayedd.examenFinal.*")
public class TestShuffleLite {
    @Rule
    public Timeout globalTimeout = new Timeout(80000);

    
    @Test
    public void IO_Tests()
    {
	// No IO Tests but must write file
	System.out.println("\n");
    }

    public void doTestShuffleLite(String comment, ShuffleLite<Integer> expected, ShuffleLite<Integer> result){
	assertEquals(comment, expected.toString(), result.toString());
    }
    
    @Test
    public void Test_empty_0_times()
    {
	int times = 0;
	
	ShuffleLite<Integer> result = new ShuffleLite();
	result.shuffle(times);
    

	ShuffleLite<Integer> expected = new ShuffleLite();
	
	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_empty_5_times()
    {
	int times = 5;
	
	ShuffleLite<Integer> result = new ShuffleLite();
	result.shuffle(times);
    

	ShuffleLite<Integer> expected = new ShuffleLite();
	
	doTestShuffleLite("", expected, result);
    }
    

    @Test
    public void Test_1_elements_0_times()
    {
	int times = 0;
	
	ShuffleLite<Integer> result = new ShuffleLite();
	result.add(0);
	result.shuffle(times);
    

	ShuffleLite<Integer> expected = new ShuffleLite();
	expected.add(0);
	
	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_4_elements_minus_5_times()
    {
	int times = -4;
	
	ShuffleLite<Integer> result = new ShuffleLite();
	result.add(0);
	result.add(1);
	result.add(2);
	result.add(3);
	result.shuffle(times);
    

	ShuffleLite<Integer> expected = new ShuffleLite();
	expected.add(0);
	expected.add(1);
	expected.add(2);
	expected.add(3);
	
	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_1_element_1_times()
    {
	int times = 1;
	
	ShuffleLite<Integer> result = new ShuffleLite();
	result.add(0);
	result.shuffle(times);
    

	ShuffleLite<Integer> expected = new ShuffleLite();
	expected.add(0);
	
	doTestShuffleLite("", expected, result);
    }

    
    
    @Test
    public void Test_1_element_5_times()
    {
    	int times = 5;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);

    	doTestShuffleLite("", expected, result);
    }
    

    @Test
    public void Test_2_elements_0_times()
    {
    	int times = 0;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);	
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);

    	doTestShuffleLite("", expected, result);
    }


    @Test
    public void Test_2_elements_1_times()
    {
    	int times = 1;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);	
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);

    	doTestShuffleLite("", expected, result);
    }


    @Test
    public void Test_3_elements_0_times()
    {
    	int times = 0;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);		
    	result.shuffle(times);
    
    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);	

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_3_elements_1_times()
    {
    	int times = 1;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);		
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(2);
	expected.add(1);	

    	doTestShuffleLite("", expected, result);
    }


    @Test
    public void Test_3_elements_2_times()
    {
    	int times = 2;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);		
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);	

    	doTestShuffleLite("", expected, result);
    }


    @Test
    public void Test_4_elements_0_times()
    {
    	int times = 0;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);			
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);
	expected.add(3);	

    	doTestShuffleLite("", expected, result);
    }
    
    @Test
    public void Test_4_elements_1_times()
    {
    	int times = 1;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);			
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(2);
	expected.add(1);
	expected.add(3);	

    	doTestShuffleLite("", expected, result);
    }
    
    @Test
    public void Test_4_elements_2_times()
    {
    	int times = 2;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);			
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);
	expected.add(3);	

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_5_elements_0_times()
    {
    	int times = 0;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	result.add(4);				
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);
	expected.add(3);
	expected.add(4);		

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_5_elements_1_times()
    {
    	int times = 1;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	result.add(4);				
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(3);
	expected.add(1);
	expected.add(4);
	expected.add(2);

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_5_elements_2_times()
    {
    	int times = 2;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	result.add(4);				
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(4);
	expected.add(3);
	expected.add(2);
	expected.add(1);

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_5_elements_3_times()
    {
    	int times = 3;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	result.add(4);				
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(2);
	expected.add(4);
	expected.add(1);
	expected.add(3);

    	doTestShuffleLite("", expected, result);
    }

    @Test
    public void Test_5_elements_4_times()
    {
    	int times = 4;
	
    	ShuffleLite<Integer> result = new ShuffleLite();
    	result.add(0);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	result.add(4);				
    	result.shuffle(times);

    	ShuffleLite<Integer> expected = new ShuffleLite();
    	expected.add(0);
	expected.add(1);
	expected.add(2);
	expected.add(3);
	expected.add(4);

    	doTestShuffleLite("", expected, result);
    }
    
}

