package aoc.y2020.day8;

public interface Input {
    Instruction[] sample = new Instruction[] { new Instruction("nop", +0), new Instruction("acc", +1),
            new Instruction("jmp", +4), new Instruction("acc", +3), new Instruction("jmp", -3),
            new Instruction("acc", -99), new Instruction("acc", +1), new Instruction("jmp", -4),
            new Instruction("acc", +6) };

    Instruction[] puzzle = new Instruction[] { new Instruction("acc", +42), new Instruction("acc", -12),
            new Instruction("nop", +112), new Instruction("acc", +47), new Instruction("jmp", +600),
            new Instruction("acc", +21), new Instruction("jmp", +1), new Instruction("acc", +0),
            new Instruction("acc", +50), new Instruction("jmp", +16), new Instruction("acc", +10),
            new Instruction("jmp", +56), new Instruction("acc", -5), new Instruction("nop", +179),
            new Instruction("nop", +36), new Instruction("jmp", +341), new Instruction("acc", -12),
            new Instruction("nop", +580), new Instruction("acc", -9), new Instruction("jmp", +112),
            new Instruction("acc", +12), new Instruction("acc", +6), new Instruction("acc", +40),
            new Instruction("acc", +1), new Instruction("jmp", +237), new Instruction("acc", +50),
            new Instruction("jmp", +61), new Instruction("nop", +542), new Instruction("jmp", +644),
            new Instruction("nop", +598), new Instruction("nop", +280), new Instruction("acc", +34),
            new Instruction("acc", +10), new Instruction("jmp", +486), new Instruction("acc", +34),
            new Instruction("nop", +152), new Instruction("acc", +35), new Instruction("jmp", +629),
            new Instruction("acc", +37), new Instruction("jmp", +447), new Instruction("acc", +50),
            new Instruction("nop", +522), new Instruction("acc", +43), new Instruction("jmp", +271),
            new Instruction("jmp", +451), new Instruction("acc", +27), new Instruction("jmp", +1),
            new Instruction("acc", +24), new Instruction("nop", +532), new Instruction("jmp", +494),
            new Instruction("acc", +39), new Instruction("acc", -10), new Instruction("acc", +42),
            new Instruction("acc", -9), new Instruction("jmp", +54), new Instruction("acc", +36),
            new Instruction("jmp", +236), new Instruction("acc", +34), new Instruction("acc", +47),
            new Instruction("nop", +613), new Instruction("acc", +27), new Instruction("jmp", +561),
            new Instruction("acc", +3), new Instruction("acc", -5), new Instruction("acc", +11),
            new Instruction("acc", +19), new Instruction("jmp", +111), new Instruction("acc", +32),
            new Instruction("nop", -52), new Instruction("jmp", +108), new Instruction("acc", -16),
            new Instruction("acc", +40), new Instruction("jmp", +207), new Instruction("nop", -44),
            new Instruction("acc", +47), new Instruction("jmp", +159), new Instruction("nop", +150),
            new Instruction("acc", +43), new Instruction("acc", +7), new Instruction("jmp", +200),
            new Instruction("nop", +141), new Instruction("acc", +2), new Instruction("jmp", +487),
            new Instruction("acc", +27), new Instruction("nop", +122), new Instruction("nop", +519),
            new Instruction("jmp", +22), new Instruction("nop", +27), new Instruction("nop", +251),
            new Instruction("acc", -2), new Instruction("jmp", +171), new Instruction("acc", -11),
            new Instruction("jmp", +242), new Instruction("acc", +14), new Instruction("acc", -11),
            new Instruction("jmp", +540), new Instruction("acc", -5), new Instruction("acc", +47),
            new Instruction("acc", +14), new Instruction("jmp", +252), new Instruction("acc", +34),
            new Instruction("acc", +28), new Instruction("acc", +1), new Instruction("jmp", +311),
            new Instruction("jmp", +1), new Instruction("acc", +28), new Instruction("acc", +0),
            new Instruction("jmp", +321), new Instruction("acc", +23), new Instruction("acc", +8),
            new Instruction("acc", +26), new Instruction("acc", +0), new Instruction("jmp", +202),
            new Instruction("jmp", +541), new Instruction("acc", +21), new Instruction("acc", -9),
            new Instruction("acc", +7), new Instruction("jmp", +81), new Instruction("acc", +5),
            new Instruction("acc", +31), new Instruction("acc", -16), new Instruction("jmp", +56),
            new Instruction("acc", -1), new Instruction("acc", +21), new Instruction("acc", +45),
            new Instruction("acc", -7), new Instruction("jmp", +278), new Instruction("acc", +0),
            new Instruction("acc", +2), new Instruction("acc", -4), new Instruction("jmp", +514),
            new Instruction("acc", -1), new Instruction("acc", -16), new Instruction("acc", +32),
            new Instruction("jmp", +248), new Instruction("acc", +25), new Instruction("jmp", +333),
            new Instruction("acc", -18), new Instruction("acc", +0), new Instruction("acc", +25),
            new Instruction("acc", +43), new Instruction("jmp", +416), new Instruction("acc", +18),
            new Instruction("nop", -127), new Instruction("acc", +37), new Instruction("acc", -4),
            new Instruction("jmp", +495), new Instruction("nop", +16), new Instruction("jmp", +1),
            new Instruction("jmp", +320), new Instruction("acc", +22), new Instruction("jmp", +453),
            new Instruction("acc", -3), new Instruction("nop", +519), new Instruction("nop", +49),
            new Instruction("jmp", +32), new Instruction("jmp", -89), new Instruction("acc", +11),
            new Instruction("acc", +31), new Instruction("jmp", +454), new Instruction("acc", +12),
            new Instruction("acc", +32), new Instruction("jmp", +283), new Instruction("acc", -2),
            new Instruction("nop", +411), new Instruction("jmp", -65), new Instruction("acc", +0),
            new Instruction("nop", +25), new Instruction("acc", +5), new Instruction("acc", +0),
            new Instruction("jmp", +284), new Instruction("acc", -15), new Instruction("jmp", +1),
            new Instruction("jmp", +166), new Instruction("acc", +27), new Instruction("acc", +50),
            new Instruction("jmp", +91), new Instruction("jmp", -104), new Instruction("nop", +71),
            new Instruction("jmp", +358), new Instruction("acc", +15), new Instruction("acc", +1),
            new Instruction("jmp", -60), new Instruction("acc", +20), new Instruction("acc", +6),
            new Instruction("acc", +10), new Instruction("jmp", +228), new Instruction("acc", -3),
            new Instruction("jmp", +316), new Instruction("acc", +5), new Instruction("acc", +11),
            new Instruction("jmp", +254), new Instruction("acc", -3), new Instruction("acc", +20),
            new Instruction("jmp", +194), new Instruction("acc", +9), new Instruction("acc", -8),
            new Instruction("jmp", +6), new Instruction("acc", +30), new Instruction("jmp", +376),
            new Instruction("acc", -19), new Instruction("acc", -8), new Instruction("jmp", -122),
            new Instruction("jmp", +3), new Instruction("nop", -41), new Instruction("jmp", -68),
            new Instruction("jmp", -119), new Instruction("nop", +434), new Instruction("acc", -16),
            new Instruction("nop", -199), new Instruction("acc", +37), new Instruction("jmp", +68),
            new Instruction("acc", +3), new Instruction("acc", +18), new Instruction("acc", +38),
            new Instruction("acc", -8), new Instruction("jmp", +327), new Instruction("nop", +110),
            new Instruction("acc", +9), new Instruction("acc", +31), new Instruction("jmp", -8),
            new Instruction("jmp", +130), new Instruction("acc", +20), new Instruction("acc", -1),
            new Instruction("nop", +16), new Instruction("jmp", +24), new Instruction("nop", +14),
            new Instruction("nop", -40), new Instruction("nop", -57), new Instruction("acc", +10),
            new Instruction("jmp", +239), new Instruction("nop", +164), new Instruction("nop", +196),
            new Instruction("jmp", -208), new Instruction("acc", -12), new Instruction("jmp", +284),
            new Instruction("acc", +10), new Instruction("acc", +27), new Instruction("jmp", +1),
            new Instruction("jmp", -195), new Instruction("acc", +1), new Instruction("acc", +10),
            new Instruction("acc", +25), new Instruction("acc", -17), new Instruction("jmp", +25),
            new Instruction("acc", +42), new Instruction("acc", +1), new Instruction("acc", -3),
            new Instruction("jmp", -148), new Instruction("jmp", -28), new Instruction("acc", +34),
            new Instruction("nop", -222), new Instruction("acc", +3), new Instruction("acc", +15),
            new Instruction("jmp", +115), new Instruction("acc", +26), new Instruction("acc", +36),
            new Instruction("acc", +33), new Instruction("jmp", -248), new Instruction("acc", -14),
            new Instruction("jmp", -89), new Instruction("acc", +19), new Instruction("acc", -14),
            new Instruction("acc", +34), new Instruction("jmp", +380), new Instruction("jmp", +1),
            new Instruction("jmp", -5), new Instruction("jmp", +187), new Instruction("jmp", +236),
            new Instruction("acc", -4), new Instruction("acc", +47), new Instruction("jmp", +2),
            new Instruction("jmp", +232), new Instruction("jmp", +1), new Instruction("acc", -8),
            new Instruction("jmp", +397), new Instruction("acc", +7), new Instruction("acc", +2),
            new Instruction("jmp", +136), new Instruction("jmp", +325), new Instruction("acc", +11),
            new Instruction("acc", -17), new Instruction("acc", -4), new Instruction("jmp", -43),
            new Instruction("acc", +20), new Instruction("acc", -9), new Instruction("jmp", +60),
            new Instruction("acc", +36), new Instruction("acc", +49), new Instruction("nop", +333),
            new Instruction("acc", +38), new Instruction("jmp", -169), new Instruction("acc", +2),
            new Instruction("acc", +8), new Instruction("jmp", +82), new Instruction("acc", +6),
            new Instruction("jmp", -159), new Instruction("acc", +25), new Instruction("acc", +23),
            new Instruction("acc", +18), new Instruction("acc", +41), new Instruction("jmp", -138),
            new Instruction("jmp", -145), new Instruction("acc", +49), new Instruction("acc", +37),
            new Instruction("jmp", +123), new Instruction("acc", +2), new Instruction("nop", +179),
            new Instruction("acc", -19), new Instruction("jmp", -152), new Instruction("jmp", -294),
            new Instruction("acc", +50), new Instruction("acc", +50), new Instruction("jmp", -46),
            new Instruction("acc", +17), new Instruction("jmp", -158), new Instruction("acc", -11),
            new Instruction("acc", +5), new Instruction("acc", -6), new Instruction("jmp", +278),
            new Instruction("acc", +3), new Instruction("acc", +26), new Instruction("acc", +27),
            new Instruction("acc", +24), new Instruction("jmp", -69), new Instruction("acc", +22),
            new Instruction("jmp", +204), new Instruction("acc", +15), new Instruction("acc", +49),
            new Instruction("acc", +1), new Instruction("acc", +22), new Instruction("jmp", +149),
            new Instruction("acc", +31), new Instruction("jmp", +131), new Instruction("jmp", -309),
            new Instruction("acc", +40), new Instruction("acc", +39), new Instruction("acc", +44),
            new Instruction("jmp", -216), new Instruction("acc", +15), new Instruction("acc", +17),
            new Instruction("jmp", +54), new Instruction("nop", +157), new Instruction("acc", +24),
            new Instruction("acc", +18), new Instruction("jmp", -111), new Instruction("acc", -6),
            new Instruction("jmp", +22), new Instruction("acc", +17), new Instruction("acc", -3),
            new Instruction("jmp", -228), new Instruction("acc", -2), new Instruction("acc", +41),
            new Instruction("jmp", +235), new Instruction("nop", +234), new Instruction("jmp", -82),
            new Instruction("nop", -83), new Instruction("acc", +44), new Instruction("acc", +39),
            new Instruction("nop", +216), new Instruction("jmp", -180), new Instruction("jmp", -163),
            new Instruction("acc", +13), new Instruction("acc", +0), new Instruction("jmp", +1),
            new Instruction("jmp", +301), new Instruction("acc", +14), new Instruction("nop", -187),
            new Instruction("jmp", -181), new Instruction("acc", +48), new Instruction("nop", +169),
            new Instruction("acc", +27), new Instruction("jmp", -334), new Instruction("nop", -226),
            new Instruction("acc", +3), new Instruction("jmp", -61), new Instruction("jmp", +1),
            new Instruction("acc", -15), new Instruction("jmp", -175), new Instruction("acc", +9),
            new Instruction("acc", +19), new Instruction("jmp", +223), new Instruction("acc", +20),
            new Instruction("acc", +39), new Instruction("acc", +50), new Instruction("acc", +13),
            new Instruction("jmp", -119), new Instruction("jmp", +240), new Instruction("acc", +50),
            new Instruction("acc", +40), new Instruction("acc", -14), new Instruction("jmp", +236),
            new Instruction("acc", +0), new Instruction("acc", +0), new Instruction("jmp", +34),
            new Instruction("acc", +20), new Instruction("acc", -3), new Instruction("nop", -136),
            new Instruction("acc", +4), new Instruction("jmp", -370), new Instruction("acc", +38),
            new Instruction("acc", +25), new Instruction("acc", +9), new Instruction("jmp", -240),
            new Instruction("jmp", +1), new Instruction("acc", -10), new Instruction("acc", +21),
            new Instruction("acc", +46), new Instruction("jmp", +118), new Instruction("acc", -8),
            new Instruction("acc", +12), new Instruction("nop", +64), new Instruction("acc", +0),
            new Instruction("jmp", +253), new Instruction("acc", +32), new Instruction("acc", -6),
            new Instruction("acc", +44), new Instruction("jmp", +115), new Instruction("acc", +36),
            new Instruction("acc", +23), new Instruction("acc", +21), new Instruction("nop", +88),
            new Instruction("jmp", -275), new Instruction("acc", +8), new Instruction("jmp", -127),
            new Instruction("acc", +5), new Instruction("acc", +42), new Instruction("jmp", +82),
            new Instruction("acc", +41), new Instruction("acc", +31), new Instruction("acc", +45),
            new Instruction("acc", +20), new Instruction("jmp", +131), new Instruction("acc", +21),
            new Instruction("acc", +7), new Instruction("jmp", +97), new Instruction("acc", +12),
            new Instruction("acc", +0), new Instruction("nop", +61), new Instruction("acc", +36),
            new Instruction("jmp", -106), new Instruction("acc", +20), new Instruction("acc", -1),
            new Instruction("acc", -14), new Instruction("jmp", -210), new Instruction("acc", -12),
            new Instruction("acc", -19), new Instruction("acc", -19), new Instruction("jmp", -25),
            new Instruction("acc", -11), new Instruction("nop", -247), new Instruction("acc", +0),
            new Instruction("acc", +7), new Instruction("jmp", -290), new Instruction("acc", +36),
            new Instruction("acc", +43), new Instruction("acc", +8), new Instruction("nop", -154),
            new Instruction("jmp", -102), new Instruction("acc", +8), new Instruction("acc", +31),
            new Instruction("acc", +44), new Instruction("acc", -5), new Instruction("jmp", -184),
            new Instruction("jmp", -252), new Instruction("acc", +50), new Instruction("acc", +18),
            new Instruction("acc", +5), new Instruction("jmp", -141), new Instruction("jmp", -159),
            new Instruction("acc", -4), new Instruction("acc", +8), new Instruction("acc", +4),
            new Instruction("acc", -5), new Instruction("jmp", +56), new Instruction("acc", +19),
            new Instruction("acc", +46), new Instruction("jmp", +53), new Instruction("acc", +45),
            new Instruction("jmp", -316), new Instruction("acc", -5), new Instruction("acc", -1),
            new Instruction("nop", +98), new Instruction("jmp", +195), new Instruction("jmp", +1),
            new Instruction("jmp", +58), new Instruction("acc", +15), new Instruction("nop", -471),
            new Instruction("acc", +14), new Instruction("jmp", +48), new Instruction("nop", -269),
            new Instruction("nop", +8), new Instruction("nop", -223), new Instruction("acc", +24),
            new Instruction("jmp", -288), new Instruction("jmp", +85), new Instruction("nop", -1),
            new Instruction("jmp", +1), new Instruction("jmp", +45), new Instruction("acc", +48),
            new Instruction("nop", -490), new Instruction("acc", +0), new Instruction("jmp", +37),
            new Instruction("jmp", +132), new Instruction("acc", +5), new Instruction("jmp", -256),
            new Instruction("acc", +12), new Instruction("acc", +22), new Instruction("jmp", -479),
            new Instruction("acc", +15), new Instruction("nop", -56), new Instruction("acc", -18),
            new Instruction("acc", -6), new Instruction("jmp", -157), new Instruction("nop", +16),
            new Instruction("acc", +5), new Instruction("acc", +26), new Instruction("acc", +42),
            new Instruction("jmp", -172), new Instruction("acc", -13), new Instruction("acc", -2),
            new Instruction("jmp", -237), new Instruction("acc", +9), new Instruction("acc", -10),
            new Instruction("acc", -16), new Instruction("jmp", +32), new Instruction("acc", +11),
            new Instruction("acc", +3), new Instruction("jmp", -208), new Instruction("jmp", -449),
            new Instruction("jmp", -383), new Instruction("jmp", +96), new Instruction("acc", -9),
            new Instruction("acc", -14), new Instruction("jmp", -30), new Instruction("nop", -36),
            new Instruction("jmp", +21), new Instruction("jmp", +117), new Instruction("jmp", -169),
            new Instruction("jmp", -387), new Instruction("acc", -5), new Instruction("acc", -9),
            new Instruction("jmp", -344), new Instruction("acc", +13), new Instruction("acc", +4),
            new Instruction("acc", +45), new Instruction("jmp", -219), new Instruction("acc", +9),
            new Instruction("acc", +44), new Instruction("acc", +31), new Instruction("acc", +16),
            new Instruction("jmp", -71), new Instruction("jmp", -77), new Instruction("acc", -1),
            new Instruction("acc", +40), new Instruction("acc", +31), new Instruction("jmp", -385),
            new Instruction("acc", +1), new Instruction("jmp", -255), new Instruction("nop", -20),
            new Instruction("acc", +0), new Instruction("acc", +29), new Instruction("jmp", -180),
            new Instruction("acc", +13), new Instruction("acc", +5), new Instruction("nop", -292),
            new Instruction("jmp", -204), new Instruction("acc", +30), new Instruction("jmp", -265),
            new Instruction("acc", +19), new Instruction("acc", +31), new Instruction("jmp", -457),
            new Instruction("acc", +16), new Instruction("acc", +27), new Instruction("jmp", +67),
            new Instruction("jmp", +88), new Instruction("acc", +20), new Instruction("acc", +44),
            new Instruction("acc", +27), new Instruction("jmp", -40), new Instruction("acc", +26),
            new Instruction("acc", +48), new Instruction("acc", +28), new Instruction("acc", -12),
            new Instruction("jmp", -120), new Instruction("acc", -9), new Instruction("acc", +42),
            new Instruction("jmp", -543), new Instruction("acc", +4), new Instruction("nop", +83),
            new Instruction("acc", +41), new Instruction("jmp", -28), new Instruction("acc", +40),
            new Instruction("acc", -17), new Instruction("acc", +14), new Instruction("acc", -6),
            new Instruction("jmp", -70), new Instruction("nop", -294), new Instruction("acc", -10),
            new Instruction("acc", +9), new Instruction("acc", +7), new Instruction("jmp", -322),
            new Instruction("jmp", +1), new Instruction("jmp", -46), new Instruction("acc", +0),
            new Instruction("acc", +38), new Instruction("acc", +6), new Instruction("jmp", -381),
            new Instruction("acc", +49), new Instruction("acc", -16), new Instruction("acc", +35),
            new Instruction("acc", +45), new Instruction("jmp", -184), new Instruction("acc", -6),
            new Instruction("acc", -13), new Instruction("acc", +9), new Instruction("jmp", -180),
            new Instruction("acc", +18), new Instruction("acc", +49), new Instruction("acc", -4),
            new Instruction("nop", -197), new Instruction("jmp", -395), new Instruction("nop", -266),
            new Instruction("jmp", -530), new Instruction("acc", +16), new Instruction("acc", +9),
            new Instruction("jmp", -117), new Instruction("acc", -4), new Instruction("acc", -7),
            new Instruction("acc", +44), new Instruction("acc", +35), new Instruction("jmp", -122),
            new Instruction("acc", +31), new Instruction("acc", -5), new Instruction("jmp", -503),
            new Instruction("jmp", -555), new Instruction("acc", +19), new Instruction("acc", +25),
            new Instruction("acc", -10), new Instruction("acc", +50), new Instruction("jmp", -493),
            new Instruction("jmp", -591), new Instruction("acc", +40), new Instruction("jmp", -491),
            new Instruction("nop", +28), new Instruction("nop", -48), new Instruction("acc", +11),
            new Instruction("nop", -25), new Instruction("jmp", -591), new Instruction("jmp", +1),
            new Instruction("acc", -15), new Instruction("acc", +21), new Instruction("acc", +46),
            new Instruction("jmp", -199), new Instruction("jmp", +1), new Instruction("acc", +42),
            new Instruction("acc", +10), new Instruction("acc", -11), new Instruction("jmp", -213),
            new Instruction("acc", -8), new Instruction("acc", +2), new Instruction("acc", +36),
            new Instruction("jmp", -470), new Instruction("acc", +37), new Instruction("jmp", -195),
            new Instruction("jmp", -38), new Instruction("acc", +17), new Instruction("jmp", -26),
            new Instruction("nop", -376), new Instruction("acc", +27), new Instruction("acc", +11),
            new Instruction("jmp", -185), new Instruction("acc", +44), new Instruction("acc", +12),
            new Instruction("acc", +9), new Instruction("acc", +14), new Instruction("jmp", -626),
            new Instruction("jmp", -89), new Instruction("acc", +45), new Instruction("acc", +23),
            new Instruction("acc", +13), new Instruction("acc", +19), new Instruction("jmp", +1) };
}
