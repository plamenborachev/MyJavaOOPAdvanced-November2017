package assembler_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.Part;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AssemblerTest {

    private Assembler assembler;
    private Part attackModifyingPart;
    private Part deffenceModifyingPart;

    @Before
    public void init(){
        this.assembler = new VehicleAssembler();

        Part part1 = mock(AttackModifyingPart.class);
        when(part1.getPrice()).thenReturn(new BigDecimal("1000"));

        Part part2 = mock(DefenseModifyingPart.class);
        when(part1.getPrice()).thenReturn(new BigDecimal("1000"));

        this.attackModifyingPart = part1;
        this.deffenceModifyingPart = part2;
    }

    @Test
    public void testAddingEndurancePart(){
        this.assembler.addArsenalPart(this.attackModifyingPart);
        Assert.assertEquals(new BigDecimal("1000"), this.assembler.getTotalPrice());
    }

    @Test
    public void testAddingDeffPart(){
        this.assembler.addShellPart(this.deffenceModifyingPart);
        Assert.assertEquals(new BigDecimal("1000"), this.assembler.getTotalPrice());
    }
}
