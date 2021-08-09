package utils;

public abstract class Runner {
    public void runAll(AocProblem[] all) {
        var total = 0L;

        for (var problem : all) {
            var start = System.currentTimeMillis();

            problem.solve();

            var diff = System.currentTimeMillis() - start;

            System.out.println(problem + " " + diff + " ms");
            total += diff;
        }

        System.out.println("Total: " + total + " ms");
    }
}
