package com.example;

import com.example.adapter.adapters.SquarePegAdapter;
import com.example.adapter.round.RoundHole;
import com.example.adapter.round.RoundPeg;
import com.example.adapter.square.SquarePeg;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 结构型模式-适配器模式测试
 */
@SpringBootTest
@Slf4j
class AdapterTest {

    @Test
    void test() {
        // Round fits, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            log.info("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            log.info("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            log.info("Square peg w20 does not fit into round hole r5.");
        }
    }
}
