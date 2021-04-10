package y2020.day19;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static class InputItem {
        int ndx;
        Rule rule;

        InputItem(int ndx, Rule rule) {
            this.ndx = ndx;
            this.rule = rule;
        }
    }

    public static Notes sample;
    public static Notes sample2;
    public static Notes puzzle;

    static List<InputItem> sampleRules = Arrays.asList(new InputItem(0, new AndRule(new int[] { 4, 1, 5 })),
            new InputItem(1, new OrRule(new AndRule(new int[] { 2, 3 }), new AndRule(new int[] { 3, 2 }))),
            new InputItem(2, new OrRule(new AndRule(new int[] { 4, 4 }), new AndRule(new int[] { 5, 5 }))),
            new InputItem(3, new OrRule(new AndRule(new int[] { 4, 5 }), new AndRule(new int[] { 5, 4 }))),
            new InputItem(4, new CharRule('a')), new InputItem(5, new CharRule('b')));

    static String[] sampleMsgs = new String[] { "ababbb", "bababa", "abbbab", "aaabbb", "aaaabbb", };

    static List<InputItem> sample2Rules = Arrays.asList(new InputItem(0, new AndRule(new int[] { 1, 3 })),
            new InputItem(1, new OrRule(new AndRule(new int[] { 2 }), new AndRule(new int[] { 2, 1 }))),
            new InputItem(2, new CharRule('a')), new InputItem(3, new CharRule('b')));

    static String[] sample2Msgs = new String[] { "aaaab" };

    static List<InputItem> puzzleRules = Arrays.asList(new InputItem(62, new AndRule(new int[] { 93, 93 })),
            new InputItem(41, new OrRule(new AndRule(new int[] { 40, 111 }), new AndRule(new int[] { 127, 70 }))),
            new InputItem(95, new OrRule(new AndRule(new int[] { 127, 93 }), new AndRule(new int[] { 40, 40 }))),
            new InputItem(73, new OrRule(new AndRule(new int[] { 127, 24 }), new AndRule(new int[] { 40, 58 }))),
            new InputItem(121, new OrRule(new AndRule(new int[] { 127, 82 }), new AndRule(new int[] { 40, 75 }))),
            new InputItem(101, new AndRule(new int[] { 93, 95 })),
            new InputItem(54, new OrRule(new AndRule(new int[] { 127, 64 }), new AndRule(new int[] { 40, 112 }))),
            new InputItem(76, new OrRule(new AndRule(new int[] { 71, 40 }), new AndRule(new int[] { 106, 127 }))),
            new InputItem(25, new OrRule(new AndRule(new int[] { 50, 40 }), new AndRule(new int[] { 126, 127 }))),
            new InputItem(21, new AndRule(new int[] { 127, 65 })),
            new InputItem(111, new OrRule(new AndRule(new int[] { 65, 40 }), new AndRule(new int[] { 57, 127 }))),
            new InputItem(44, new OrRule(new AndRule(new int[] { 127, 127 }), new AndRule(new int[] { 127, 40 }))),
            new InputItem(120, new OrRule(new AndRule(new int[] { 98, 127 }), new AndRule(new int[] { 108, 40 }))),
            new InputItem(59, new OrRule(new AndRule(new int[] { 40, 111 }), new AndRule(new int[] { 127, 34 }))),
            new InputItem(63, new OrRule(new AndRule(new int[] { 65, 40 }), new AndRule(new int[] { 65, 127 }))),
            new InputItem(8, new AndRule(new int[] { 42 })),
            new InputItem(106, new OrRule(new AndRule(new int[] { 44, 40 }), new AndRule(new int[] { 50, 127 }))),
            new InputItem(98, new OrRule(new AndRule(new int[] { 127, 48 }), new AndRule(new int[] { 40, 13 }))),
            new InputItem(1, new OrRule(new AndRule(new int[] { 36, 127 }), new AndRule(new int[] { 74, 40 }))),
            new InputItem(52, new OrRule(new AndRule(new int[] { 127, 20 }), new AndRule(new int[] { 40, 114 }))),
            new InputItem(114, new OrRule(new AndRule(new int[] { 50, 127 }), new AndRule(new int[] { 88, 40 }))),
            new InputItem(2, new OrRule(new AndRule(new int[] { 29, 40 }), new AndRule(new int[] { 45, 127 }))),
            new InputItem(57, new OrRule(new AndRule(new int[] { 127, 127 }), new AndRule(new int[] { 40, 127 }))),
            new InputItem(65, new AndRule(new int[] { 40, 40 })),
            new InputItem(43, new OrRule(new AndRule(new int[] { 40, 89 }), new AndRule(new int[] { 127, 73 }))),
            new InputItem(42, new OrRule(new AndRule(new int[] { 40, 69 }), new AndRule(new int[] { 127, 5 }))),
            new InputItem(110, new OrRule(new AndRule(new int[] { 127, 122 }), new AndRule(new int[] { 40, 128 }))),
            new InputItem(83, new OrRule(new AndRule(new int[] { 40, 30 }), new AndRule(new int[] { 127, 103 }))),
            new InputItem(105, new OrRule(new AndRule(new int[] { 110, 40 }), new AndRule(new int[] { 53, 127 }))),
            new InputItem(19, new OrRule(new AndRule(new int[] { 116, 127 }), new AndRule(new int[] { 59, 40 }))),
            new InputItem(90, new OrRule(new AndRule(new int[] { 40, 40 }), new AndRule(new int[] { 127, 127 }))),
            new InputItem(75, new AndRule(new int[] { 93, 90 })), new InputItem(11, new AndRule(new int[] { 42, 31 })),
            new InputItem(20, new OrRule(new AndRule(new int[] { 127, 61 }), new AndRule(new int[] { 40, 62 }))),
            new InputItem(16, new OrRule(new AndRule(new int[] { 83, 127 }), new AndRule(new int[] { 12, 40 }))),
            new InputItem(33, new OrRule(new AndRule(new int[] { 65, 127 }), new AndRule(new int[] { 62, 40 }))),
            new InputItem(4, new OrRule(new AndRule(new int[] { 81, 127 }), new AndRule(new int[] { 91, 40 }))),
            new InputItem(10, new AndRule(new int[] { 40, 57 })),
            new InputItem(18, new OrRule(new AndRule(new int[] { 61, 40 }), new AndRule(new int[] { 62, 127 }))),
            new InputItem(88, new OrRule(new AndRule(new int[] { 40, 127 }), new AndRule(new int[] { 127, 40 }))),
            new InputItem(102, new OrRule(new AndRule(new int[] { 40, 109 }), new AndRule(new int[] { 127, 107 }))),
            new InputItem(49, new OrRule(new AndRule(new int[] { 9, 127 }), new AndRule(new int[] { 51, 40 }))),
            new InputItem(81, new OrRule(new AndRule(new int[] { 25, 127 }), new AndRule(new int[] { 84, 40 }))),
            new InputItem(115, new OrRule(new AndRule(new int[] { 104, 40 }), new AndRule(new int[] { 106, 127 }))),
            new InputItem(125, new OrRule(new AndRule(new int[] { 43, 40 }), new AndRule(new int[] { 92, 127 }))),
            new InputItem(9, new OrRule(new AndRule(new int[] { 93, 127 }), new AndRule(new int[] { 127, 40 }))),
            new InputItem(130, new OrRule(new AndRule(new int[] { 106, 40 }), new AndRule(new int[] { 67, 127 }))),
            new InputItem(56, new OrRule(new AndRule(new int[] { 95, 40 }), new AndRule(new int[] { 57, 127 }))),
            new InputItem(34, new AndRule(new int[] { 40, 44 })),
            new InputItem(77, new OrRule(new AndRule(new int[] { 127, 55 }), new AndRule(new int[] { 40, 124 }))),
            new InputItem(79, new OrRule(new AndRule(new int[] { 27, 40 }), new AndRule(new int[] { 13, 127 }))),
            new InputItem(80, new OrRule(new AndRule(new int[] { 40, 41 }), new AndRule(new int[] { 127, 52 }))),
            new InputItem(82, new OrRule(new AndRule(new int[] { 126, 127 }), new AndRule(new int[] { 61, 40 }))),
            new InputItem(61, new OrRule(new AndRule(new int[] { 40, 40 }), new AndRule(new int[] { 40, 127 }))),
            new InputItem(27, new OrRule(new AndRule(new int[] { 51, 40 }), new AndRule(new int[] { 95, 127 }))),
            new InputItem(94, new OrRule(new AndRule(new int[] { 40, 127 }), new AndRule(new int[] { 93, 40 }))),
            new InputItem(6, new OrRule(new AndRule(new int[] { 78, 127 }), new AndRule(new int[] { 129, 40 }))),
            new InputItem(24, new OrRule(new AndRule(new int[] { 61, 127 }), new AndRule(new int[] { 50, 40 }))),
            new InputItem(126, new AndRule(new int[] { 127, 40 })),
            new InputItem(108, new OrRule(new AndRule(new int[] { 82, 40 }), new AndRule(new int[] { 56, 127 }))),
            new InputItem(29, new OrRule(new AndRule(new int[] { 127, 62 }), new AndRule(new int[] { 40, 61 }))),
            new InputItem(70, new AndRule(new int[] { 127, 95 })),
            new InputItem(99, new OrRule(new AndRule(new int[] { 90, 127 }), new AndRule(new int[] { 61, 40 }))),
            new InputItem(127, new CharRule('b')),
            new InputItem(124, new OrRule(new AndRule(new int[] { 15, 127 }), new AndRule(new int[] { 120, 40 }))),
            new InputItem(48, new OrRule(new AndRule(new int[] { 40, 65 }), new AndRule(new int[] { 127, 50 }))),
            new InputItem(74, new OrRule(new AndRule(new int[] { 50, 127 }), new AndRule(new int[] { 61, 40 }))),
            new InputItem(55, new OrRule(new AndRule(new int[] { 40, 66 }), new AndRule(new int[] { 127, 16 }))),
            new InputItem(64, new AndRule(new int[] { 40, 9 })),
            new InputItem(109, new OrRule(new AndRule(new int[] { 127, 88 }), new AndRule(new int[] { 40, 95 }))),
            new InputItem(112, new OrRule(new AndRule(new int[] { 40, 94 }), new AndRule(new int[] { 127, 9 }))),
            new InputItem(30, new OrRule(new AndRule(new int[] { 44, 127 }), new AndRule(new int[] { 61, 40 }))),
            new InputItem(47, new OrRule(new AndRule(new int[] { 121, 127 }), new AndRule(new int[] { 130, 40 }))),
            new InputItem(28, new OrRule(new AndRule(new int[] { 27, 40 }), new AndRule(new int[] { 56, 127 }))),
            new InputItem(23, new OrRule(new AndRule(new int[] { 48, 40 }), new AndRule(new int[] { 97, 127 }))),
            new InputItem(96, new OrRule(new AndRule(new int[] { 40, 95 }), new AndRule(new int[] { 127, 65 }))),
            new InputItem(37, new OrRule(new AndRule(new int[] { 63, 40 }), new AndRule(new int[] { 7, 127 }))),
            new InputItem(116, new OrRule(new AndRule(new int[] { 123, 127 }), new AndRule(new int[] { 36, 40 }))),
            new InputItem(7, new OrRule(new AndRule(new int[] { 40, 44 }), new AndRule(new int[] { 127, 65 }))),
            new InputItem(35, new AndRule(new int[] { 40, 127 })),
            new InputItem(69, new OrRule(new AndRule(new int[] { 40, 125 }), new AndRule(new int[] { 127, 72 }))),
            new InputItem(36, new OrRule(new AndRule(new int[] { 65, 127 }), new AndRule(new int[] { 94, 40 }))),
            new InputItem(123, new OrRule(new AndRule(new int[] { 127, 65 }), new AndRule(new int[] { 40, 57 }))),
            new InputItem(85, new OrRule(new AndRule(new int[] { 40, 126 }), new AndRule(new int[] { 127, 65 }))),
            new InputItem(39, new OrRule(new AndRule(new int[] { 9, 127 }), new AndRule(new int[] { 126, 40 }))),
            new InputItem(26, new OrRule(new AndRule(new int[] { 127, 35 }), new AndRule(new int[] { 40, 88 }))),
            new InputItem(5, new OrRule(new AndRule(new int[] { 22, 127 }), new AndRule(new int[] { 100, 40 }))),
            new InputItem(60, new OrRule(new AndRule(new int[] { 40, 90 }), new AndRule(new int[] { 127, 65 }))),
            new InputItem(71, new OrRule(new AndRule(new int[] { 9, 127 }), new AndRule(new int[] { 61, 40 }))),
            new InputItem(78, new OrRule(new AndRule(new int[] { 40, 82 }), new AndRule(new int[] { 127, 39 }))),
            new InputItem(87, new OrRule(new AndRule(new int[] { 21, 40 }), new AndRule(new int[] { 101, 127 }))),
            new InputItem(46, new OrRule(new AndRule(new int[] { 126, 127 }), new AndRule(new int[] { 44, 40 }))),
            new InputItem(66, new OrRule(new AndRule(new int[] { 127, 54 }), new AndRule(new int[] { 40, 37 }))),
            new InputItem(13, new OrRule(new AndRule(new int[] { 127, 61 }), new AndRule(new int[] { 40, 50 }))),
            new InputItem(91, new OrRule(new AndRule(new int[] { 40, 119 }), new AndRule(new int[] { 127, 99 }))),
            new InputItem(31, new OrRule(new AndRule(new int[] { 77, 40 }), new AndRule(new int[] { 105, 127 }))),
            new InputItem(38, new OrRule(new AndRule(new int[] { 60, 40 }), new AndRule(new int[] { 106, 127 }))),
            new InputItem(128, new OrRule(new AndRule(new int[] { 38, 40 }), new AndRule(new int[] { 2, 127 }))),
            new InputItem(3, new OrRule(new AndRule(new int[] { 46, 40 }), new AndRule(new int[] { 49, 127 }))),
            new InputItem(117, new OrRule(new AndRule(new int[] { 44, 127 }), new AndRule(new int[] { 95, 40 }))),
            new InputItem(17, new OrRule(new AndRule(new int[] { 14, 40 }), new AndRule(new int[] { 79, 127 }))),
            new InputItem(84, new OrRule(new AndRule(new int[] { 127, 65 }), new AndRule(new int[] { 40, 65 }))),
            new InputItem(45, new OrRule(new AndRule(new int[] { 90, 127 }), new AndRule(new int[] { 95, 40 }))),
            new InputItem(86, new OrRule(new AndRule(new int[] { 127, 18 }), new AndRule(new int[] { 40, 85 }))),
            new InputItem(72, new OrRule(new AndRule(new int[] { 40, 80 }), new AndRule(new int[] { 127, 4 }))),
            new InputItem(103, new AndRule(new int[] { 93, 62 })),
            new InputItem(50, new OrRule(new AndRule(new int[] { 93, 127 }), new AndRule(new int[] { 40, 40 }))),
            new InputItem(104, new OrRule(new AndRule(new int[] { 35, 40 }), new AndRule(new int[] { 65, 127 }))),
            new InputItem(89, new OrRule(new AndRule(new int[] { 117, 127 }), new AndRule(new int[] { 46, 40 }))),
            new InputItem(51, new AndRule(new int[] { 127, 127 })),
            new InputItem(107, new OrRule(new AndRule(new int[] { 90, 40 }), new AndRule(new int[] { 88, 127 }))),
            new InputItem(0, new AndRule(new int[] { 8, 11 })),
            new InputItem(32, new OrRule(new AndRule(new int[] { 40, 102 }), new AndRule(new int[] { 127, 115 }))),
            new InputItem(113, new OrRule(new AndRule(new int[] { 96, 40 }), new AndRule(new int[] { 26, 127 }))),
            new InputItem(14, new OrRule(new AndRule(new int[] { 10, 40 }), new AndRule(new int[] { 24, 127 }))),
            new InputItem(58, new OrRule(new AndRule(new int[] { 50, 127 }), new AndRule(new int[] { 126, 40 }))),
            new InputItem(15, new OrRule(new AndRule(new int[] { 23, 127 }), new AndRule(new int[] { 87, 40 }))),
            new InputItem(68, new OrRule(new AndRule(new int[] { 1, 40 }), new AndRule(new int[] { 28, 127 }))),
            new InputItem(40, new CharRule('a')),
            new InputItem(119, new OrRule(new AndRule(new int[] { 65, 40 }), new AndRule(new int[] { 50, 127 }))),
            new InputItem(12, new OrRule(new AndRule(new int[] { 40, 33 }), new AndRule(new int[] { 127, 56 }))),
            new InputItem(118, new OrRule(new AndRule(new int[] { 57, 127 }), new AndRule(new int[] { 35, 40 }))),
            new InputItem(122, new OrRule(new AndRule(new int[] { 113, 127 }), new AndRule(new int[] { 3, 40 }))),
            new InputItem(67, new OrRule(new AndRule(new int[] { 127, 9 }), new AndRule(new int[] { 40, 126 }))),
            new InputItem(22, new OrRule(new AndRule(new int[] { 68, 40 }), new AndRule(new int[] { 47, 127 }))),
            new InputItem(92, new OrRule(new AndRule(new int[] { 86, 40 }), new AndRule(new int[] { 76, 127 }))),
            new InputItem(93, new OrRule(new AndRule(new int[] { 127 }), new AndRule(new int[] { 40 }))),
            new InputItem(129, new OrRule(new AndRule(new int[] { 84, 127 }), new AndRule(new int[] { 118, 40 }))),
            new InputItem(97, new OrRule(new AndRule(new int[] { 88, 127 }), new AndRule(new int[] { 65, 40 }))),
            new InputItem(100, new OrRule(new AndRule(new int[] { 17, 40 }), new AndRule(new int[] { 19, 127 }))),
            new InputItem(53, new OrRule(new AndRule(new int[] { 40, 6 }), new AndRule(new int[] { 127, 32 }))));

    static String[] puzzleMsgs = new String[] { "aabbbabaabbbbababaaababbaaaaaaaa",
            "babaabbbaaaabbbbaababbabbabaaaabbabaabba", "abbbaabbbbaabababbaaaababbabbbba", "bbaabbabbbaaabbbbbaaaaab",
            "aaabbaaaaabbabbaabaababa", "bbabbabbaabbabbbbbabbaab",
            "aababbaabbbabaaabbababbbabaaabbbbbaabaaabbbbaaabaabbabbaaabbabaabbbaaaababbbabaaaabbabbb",
            "abaabbaaaaaaababbbbbaaaa", "abaababaabaaabbbabababaabbaaababbabbbbbabbbabababbabbabbabbbbaab",
            "bbabbababbbbbabbbabbaaba", "babbbaaababbbbababaaabbbbaabbbab", "babaabbbbbababaabbbabbaa",
            "aaaaaabbaaabbabaabaabaaa", "aabbbbbbaaababbaababbbaaaaabababbaabbbab", "aabbbbbabaabbabaaababbabbbaaabaa",
            "babbbbbabbbaababaabaabbaaabbbbbbaaaaaaaa", "aabbbbaaaaaaaabbabbbbbbaaabbaabaaabbaaaabbababba",
            "ababaabbbaabbbbaabbbabab", "aaabaabbaaabaaaaaaaabbba", "aabbbabbbbbababbbababaaaabbabbbb",
            "bbbbabaabbaabbbabababbab", "bbbababbbbaaabbbbbbaaaba", "bbbabaaaabaabbaaaababbaa",
            "abbaaabbbbbabbbbbabababa", "baaabbabababbabbabbaabab", "babaabbbabbaaaabbbabaabaaabaaaaaabbabbab",
            "ababbbabbbbbbabbaaabaaabaaaabbaaabbbaabb", "abbbaabababaaaababbaaaaaaabababaaaababbb",
            "bababaaabaaaabbbaaababbb", "aaabaaabbaabbabaabababbbabbbbbaababbabaa",
            "abbbbabbbaaaaaabababbbabbbbaabbbaabababa", "aabaaabaabaabbbbbbaabbbabaaaaaabbababbbbaaaabaaa",
            "babbaabbaabaababaaaaaaab", "baabbababbabababbbaabaabaabaabbaaababbaaaaaabbaa", "aabbaaaabaabbbbaabbbbaab",
            "bbaaabbaababaabaaababaababbabaab",
            "aaabbaabababbbbaaabababbabbbabbaaaabababbabaaaaaabaabaaaaaaabbbabaaaabaa", "babbbbbbbaabaaaaabababab",
            "abbaaaaabaaabbaaababaabbbababaaabbbababaaaabbbaabaabaaba", "aaaaaabbbbbababbaaabaaababbabbababababab",
            "bbbabaaabbaababbabaababaaaabbbbbaababbba", "aaabbbbabbbbabaababbaaabababbaaabaaabbaabababaabaabbbaba",
            "baabbabababbbbbaaababbabbabbbabb", "bbbaababbabaabbabbbaabababababbbbbabaabb",
            "bababbababbaabababaababbbabaabbbbbbaababbbaabbaabbaaaabaabaaaaba", "abbbaaaaaabababbbbaaabab",
            "bbaabbbaabaabbbaabaaabab", "aabaabababbaabaaabbabaaaabbabbaaaababbbaaaabbabbbaaaabbbbaaaabbbbaabbabb",
            "aababbbbababbababbaabbababaababaaaaaaaabbaaaabbabaababbbabbbabaabbaababbbbaababb",
            "abbaaaabbbabbabaababaaaa", "babbaaaaaaababbababaaaaa", "bbbbaabbbbaaabbabbaababa",
            "ababbbabaabbbabbabaababa", "abbababbaabbbbbaabbbbbabaaabbbab",
            "aaabbbaaababaabbaabababbababaaaaaaabaabaabbaabbb", "bbaabbabbaabbbaabbbbabba",
            "aaaaaabbabbbaaaabaabaabbabbbbaba", "bbbbbabbababbbaaabaaabbbbbbbabbaaaaaabbb",
            "abaaababaabaaababbaaaaaaaaaabaaababbbbbbbbabbaaaaabbaabbababbababaaaaababaaaaabbaaabbabbbbabbbaa",
            "aabbbbaabbbbbabbbbbabbaa", "bbabababaabaaaabaaaabbaa",
            "babbbbaabaababbbbababbaaabaaaabaaaabbbabbabbbabbbbbbbbaa",
            "abbbabbbabbbaaaabaaaabbbabbbbababbbbaaaabbaababbababbbba", "bbbabaaaabbbaaaaaabbbbba",
            "aaaaaabbaaaaaabaaabbaaba", "babbbabaaababaabbababbba", "abbbbabbbaababaabaaaaababababbab",
            "bbbbaabbbbababaababaabaa", "baabbaabbabbaaaabababaaaaaabbaababbaabaa", "baababaabaababbabbbbabbb",
            "aabbabbababaabbbabaababb", "abaabbbbaaababaaabbaabab", "babbbababbbbbabbabaabbbaababbbaabaabaaaa",
            "abbababbbbbbabbabaabaabbaabaabbaababaababaaabaaabbababababbaaaab",
            "baaabbaababbbabbabbabbbaaaaaaaababbbaabaaaabaabaababaabbbbabbaab",
            "baaaaaabbaaaaabbbaabaaaabaabbbabbbbababaabaaaaaabbaaaababaaaaaabaaaabbaa",
            "abaabbbbababbbabaabaabbbbbbaaabaaababbaaabababab", "ababaaabaabaabbbbbbbaaaa",
            "baaabbabbabbbaaaaababbbaaabbbaaa", "baabababbbbabbbbbbabaaab", "abbbaaababaabbbababaaaba",
            "babbaaabaaabbababbaaaaabbbbbbabbbbbaaabaaaababaaaaabbaba", "aabbbaaabababbabbabaaaaa",
            "bbaaabbbabaabaabbababbbbbbbbabbbbabbabaabbbbbaaaaaaabbab", "abaaaabbabaaaaaaaaababbb",
            "baababaabbbbababbbbaaaaa", "babbaaaaaabaabababaabaab", "babbbbaabaabbbbbbaaaabbabaabaaaa",
            "bbbbaabbaaababbabaababbb", "abbbaaaabbbabbababaabbab",
            "bbaaaabbbbbaababaaaabaababaabbbabbbaaababbaabaaabaababaaaababaabbbbabaabbabaaababaaaaabb",
            "aaabbaaaaaabaabaaabbaaaabbaaabbabababbaabbbabbba",
            "aaabaaabaabababbbabaabbbbbaaabbaaabbbbabbbabbbabbbbaaaab", "abbbabbbabbbbbbaaaaaabbb",
            "ababaababbbaaabbabababba", "aabbaabaaababbabbaaababa",
            "ababaaabaaaabaabbbabababbbbaabaaaaababbabbbbaabababbaababbbbabba", "babbbbbbabaaaaaaababbbba",
            "aaabbbbababbbaaaabaaaaba", "ababaababababaaaaabaabbbbababaabaabbbbbbbabaabbbaabababaabaabbab",
            "bbbbbbababaaaabbbbababba", "babaabbabbaabbbabbaaabab", "aaabaabbababaababbabbbbabaaabbba",
            "bababaabbaabaaaabbababaabbaabaaa", "abbbbbbaaabaabbbabaababb",
            "babababbbbababbbbbaabbabbaababaabbbababbbbbbababbabbababaababbaababbabaa",
            "bbbabbabbabbbaaabbababbbabbbaaaabbbbbbabbbbbbababbbbabba",
            "baaabaaaaabaabbaaaabaabbbaaabbaaabbaaaabbbbaaabbabababababababba",
            "ababbaaaabaaaabbabbbaaabbaabbaaaaabaabbb", "bbaabaabababbabbabbaaaabbabbbababaababaa",
            "bbababaababaabbbaabbbbabbbbabababababbab", "baababaabbaabbaaaaabaaaabaabbabaabaaabaabaaaaaaaaabbbbba",
            "aaababbbaabaaabaaababaaaabababbabbaabaaabbbaabaabaabaaababaaababbabababa",
            "abaaaaaabaabbbbbbababaaaaabaaabaabbbaababbbbabba",
            "bbababaaaababaabababbbabaaabbabbbaaaabbbbaaaababbaaababa", "baababababbbabaaaaaaabba",
            "aaabbabaaaabbabbaaabbbbbabaaabab", "baabbaaaabbbbabbabaabbbbbaabbabb",
            "abaaabbbbabbbbabaababbbaabbaaabaabaabbbaabbbbaab", "ababbabbabaabbbaabbbbbab",
            "bbababbbabaabababbababaababbbbaaaaaaabbaaabbaaabaaaabaaaaaaaababaaaaaaab", "aabbbbabbbabbabbbbbaaaba",
            "abababaaabbababbabaabaaa", "babbbbbabaaabaabbaaabbbb", "abaabbaabaabaaaabaabaaaabbaababa",
            "aababaabbbaabaaabbbaabba", "bbababbbaababaabbbbaabbb", "baaabaabaaaabaabbababbbb",
            "bbaabaabbaabbaaabaaabbbb", "aaababbaababaababbaaaaba", "babbbbbbabbbaababaaabbba",
            "babaabbbaababaababaabbab", "aaaabbbbababaababbaaabaa", "aaaaaabababbbbaababbaaababbabbbb",
            "aaabaaaaaabbabaabbaabaaa", "aaaaaabaaaababaaabaaabaa", "baaabaaaaabaabbbbbaaabba",
            "abaaaaababaaaabaaaabbbbaaabbbbaaaabaabbaabaababbbabbbaab",
            "baaaaaabbaaaabaaaaaaaabababababbaabbaababababbbbaaaaabaaabbbbbba", "aaababaabbaaabaabbabbbabbbaabaaa",
            "bbaaabaaaaaaaaaaaaaaaaababbbabaa", "bbbbbaaabbbaaaaabbbaabba",
            "baaabbabbaaaaaabaababbaaabaababaaaaaababaaaaabaababbabba", "bbbabbbbbbaabbabaaaabbba",
            "aabaabbbabbbbabbaababbaabaaaabaaaabbbbaaaaabbbaaaaabbbba", "abaaaaaabaabbaabbbaaabbbbabaaaaa",
            "aaabbbbbbaabbbbabbbabaab", "baabbaabaaabaabaabaaaaaaabababba", "aababbabaaabaabbabbbabba",
            "aababaababbbbabbaabaabbaaabababaaaabbbab", "abbaaabbbbbbabbabbaaaabbbbaaabbbbbaaaaabbaabbaaabbaababb",
            "aabaabbbababaabaabaabbbbaabbaabb",
            "bbbabaabaaabbaabbbbaabbbbaabaaabbbabbbbabbaaaaabbaababaaaaabbaaabbaaaaaa",
            "baaaaaabbabbbbbbbbaabbabaabbbaab", "bbbabbabaaaabbbaaabaabaabaaabababbbabbbbababaaba",
            "aaaaaabbaabaaabaabaababb", "abbbaababaabbabaababaaaa", "babbaaabbbbbababbabaabba",
            "abbabbbaaaaabaaaaabbababbbbbbaabbaabbaaaaaabbabbbbbaaaabaabbbaababaaabab", "aaabbbbbbaaabbaabbabaaab",
            "aaabbabaaaabaabbaabaaabb", "bbabbbaaaabaabbababaabbaaabababaaabbbaab",
            "aabbaabaabbaaabaababbababbbaabaababbaababbbbaaba", "bbababbbbaaaabbbaabaababbaaaabab",
            "baababaabbaaababbbaabaaaabaabbbaabbbaaaaaaabbabababaabbbbababbabbbaaabbb", "babaaaabababbaabbbbaaaab",
            "bbababbbbaabbbbbbabbabab", "ababbbaabbbaababaaaaaaab", "aababbabbabbbaaababbaaaababbabbbbbaababb",
            "aaabbaaaaabbabbaaabbabaaabbaabaa", "abbaaabaabaaaabbaabaababbabbbaab", "aaabbaaababbaabababbabba",
            "aabbaabaaaabbbbbaabbbaba", "abbaaabbbaaaabbabbabbbba", "baaaabbaaababaababababab",
            "bababaababbbbbbaabbabaaa", "abbaaaabbbabbababbbaabaaabbbbabbaaabbbaa", "bbabbbaaaabbbbaaaaaaaaaa",
            "babbbbbbaaabbabaabbabbbb", "abbaaabbbbabbabbaaabbaabaaaaaabbbbbbbbabbaabbaab",
            "bbbbabaababbbaaabbaaabbbaabbaababaabaaba", "baabbbabbbbbbbbabbbabaabaabaaabb", "aababaabaaabbbbabbbbbaaa",
            "babababbaabaababbaaaaaaa", "bbbaabaabbbaaaaabbabbbba",
            "abbabaabaabaaaaabaaaabbbbaaabaaaaaaaabbaaababbbbbbaabbaabbbbaaabbbbbabbb",
            "baabbaabbabbbbaabbaabbaabbabbbaabaabbabb", "baaabaabbabbabbbaaaaaaaabbaabaaaaaababbb",
            "baabaabbbbbabaaabbabaabbbbbabaabbbbbabbaaaababbb", "bbbbbbabbaababbaaaabbaaabaababbb",
            "babaabbbaabbbbaabababbbbbbbaabbaaaaaaaab", "aabaaaabbabbaabbabbaabbbaaaabbabaabababa",
            "aaaaaabaaabbabaabbaabaabaaaabaab", "aaabbbbaaaababaabaaabbaaaaaaaabbbabbbaab",
            "abbbbabbaabbbabbabbbaababbbababaabbabaab", "bbabbbaabaabbaababaaabab", "aababaabaaabbbbbbabaabaa",
            "aaababbaabbaaabbbaabbbab", "baabbbbaabbabaababbababbbbabaaabbbbbabaabbaabbaabaababaabbbbabbbbaabbaba",
            "bbaaabbbbabaabbababbbbbbbaabbbbabbbaaaabaaaabbba", "bbabababbabbbbbaaaaaabbaaaaabbab",
            "bbaabaabbaabbbbbbbaabaabbabbaabaaabababa", "ababbabbaabbbbbbbbabbbbb", "aaaaabbbbbabaabbabbabbabbababbaa",
            "aabbabaaaabbaabaabaaaaab", "ababbbabaabaaaababaaabbbbaabbbbabbbbaaba",
            "ababbabbaabaabbabaabbbbbaaaaaabbaabaaabb", "bbbbbbabbaabbaababbabaaa",
            "abbbaaaaaaabbababaabbaabbaabaabbaaaabaaa", "baaaaaabbbaaaabbabaabbbabaabababbabaaaabbaabbbbbbabbbabb",
            "bbaabbbabbbabbaabbaabbbaababababbbababaaaababbbbbaabbbbaababaaababaaabbabababaaaabbbaaaa",
            "aabbbbaabbbaabaababaababbabbabaaabbbbaabbbabaabb", "bbababaaaaabbabaaabaaabb",
            "ababababbabbbabababbbaaababababaaaababaaabbbabbbababbbaabaabbbaa",
            "baaaabaaaaaaababbbabbbbabbaaabaaabaabaabaaababbbbaaabbbbaabaaaba",
            "baabbaaaaabababbbaabaaaababaabaaaaabababbbabbaaa", "bbbaaaabbbaaaaabbaabbbabaabbaabbabbbabab",
            "baabbbbbaababaaaabbbabaaabbbbaaaabababba", "ababbaababbbaaaaaaaaabbb",
            "abbbabbbabbbabaaabbaaabbbbbabaaabbaaaaba", "aaabaabaaaabbabaabbaabaa",
            "aabababaabbabababaaaaabbbbbbaabbaabbbbbbabbaabbbbaabaaabbbbbbaabbbaabbbb",
            "baabbbaabaabbabaabababaaabaaaaab", "abababaabbabababbbbaabba", "aaabbaaabaabaaabababbaababbababa",
            "aaabbbbababbbababaaababb", "babbaaaaaaabbabaaabbaaabbbabbbbb",
            "baabbaaabbaabbabaaabbabbaaabbbbabaabbbbbabbbbbaaaaaaababbabbbabb",
            "bbbbaaabbaabaaabbababbababaababaaabaabaa", "baabbbbababbbabababbbaab", "babbbbaaaabaabababbabbbb",
            "abababaababaaababaabaaabbbbbbabbbbababbabbababaabbbaaaaa",
            "aaabaabababbbbabbbaaabbaaaaabaabbbbaababbaaaaaaa", "bbaaabbbaaababbabbabaabb", "bbbaabaaaabababbababaaaa",
            "baababaaaabbabbaababababaaabbaaaabbaabbbbbaaaaba", "aabaaabaaaaabaabaaabaabbbaaaaaaababbaaba",
            "abababaaabaaabaaabaababa", "babbaabbababaabbaaabbbaa", "abbaaaaabaaabbaabbbaabba",
            "bbabaaaabaabaaabbbbbaabbabbabababaaababbbaabbaabbbabbabaaabbabaaababbabbbabbbabb",
            "ababbabbaaababbabababbbbbbabaabbbbbbabbaaabbbaab",
            "aabababaababbabbbaaababaaabbabbaabbbbbaabbabbbbaaaababbababbbbba", "aabbabbbbbaaabbabaaabbba",
            "ababbaababbaaaaabbabababbbaabbaa", "bbbabbbbbbabababaaabbbba", "abbaaababababbaabaaaaabb",
            "aabbababbbababababbaabab", "bbaabbabaababbbaabababab", "baabababaabbabbabbabbbab",
            "bbababaaaabbbbbbbbabbbba", "ababaababbbaaabbbabaabaa", "baaaabbbbaabbaaaabbbaaabbabbbabbabaabbab",
            "aabbbbbbabbaababbabbbaaabbbaabbbabaababa", "baababaabababaaababbbbabbaaababa", "babababbbaabbbbbbbaaabaa",
            "babbbaabbaaaababbabaabaabbbaaaaaaaababaa", "aabbbbbbbabbbbbbabaabbab", "aaaabbbbaabaabababbbabba",
            "aabaababaabaababbbbaaaab", "abaabbbbababbaababbbbbbaabababab", "babbbbbbabbababbaababbbb",
            "abbabbbabaabbbaabbabbbbaaabbbaaaabbababa",
            "bababbabaaabababaabbabaaabababbbabbaaaababbbabbaaababaabababbbaaaaabbaaa",
            "aabbababaabbaababbaaabbabbabbbaaabaaaabbaaaabaaaaabbbaaa", "babbbbbbaabbaaaabaabbbab",
            "baabaaaabbaaaabbabaaaabbabaaabbbaabbbbaababbbabb", "bbaabbabbaabbaaabaaaabaa",
            "bababaababaaaaaaaabaababaabbabaababbbbbabbbabaabbbbbbaab", "baababbabaababbabaaaaabb",
            "baabbbaaaaaabbbabaaaaaaaaabbbaabbaabaabaabaababa", "aabbaabaaababbbabbbabbabaababbbbabbbaabb",
            "abbbbababbabbaabaabaabaaaaaabbbbaababbbaaabbabbb", "abaaabbbabbababbaabbbaaa",
            "bbabbabaaababbbaabbbaabaaabbbbbbabbabaaabbbbbabababbbabb",
            "aabaababbbbaabaaaaaabbbbabbaaaaabaababbbbababbbaabaababababaabaa", "aabaabaabbbababaabbbabbaaababbbb",
            "aaaaabbabbababaaabaababaaaaaabaaaababbba",
            "bbaaaaababbbbababaabababaababbabbbabbbabbbaaabbaaaabbaababbbaababbaabbaabbbaabaa",
            "babaabbbbbabbabababbaaaabbbabbaa", "aaabaaaaaaaababaabbbbbbaaaaabbbabbbaabbaaaabbbaa",
            "babbbbabababaaabaabbbaaa", "bbbbaaabbbbbbabbbbaabbabaabbabababaabaab",
            "bbabbbbbbbaabbbbbaaaaabbbbbababbbaaababbabaababbabbabbaabaabaaab",
            "abbabbbaaaabbabbabbbaabaaabaaabbabbbbbaa", "aaabbaaaabababaaaaababbaaababbbabbbbababaaaaabab",
            "abaabbaaaaababbabababbbb", "aaabaabbaababaaaabbabbbabaaabbbbbbbbbaba", "bbbbaaabbbabbabaabbbbaaa",
            "ababaaabbbababababbbabba", "bbbabbbbaaaaaabbaaaababa", "baabbbbbbbbbaaabbababbaa",
            "aaabbbabbababababaaaaaaa", "baabbbabbababbabaaabbaababbaaabbabbbbbab", "bbabbababaabababbbaaabaa",
            "bbabbabaaabbaababbabaababbbaabbbabaaaaba", "abaabbaaabbaaabaabbaaaaa",
            "baabbbbaaaabbbabbaabbbbbababbbaabbbbbbbbbbaabaababaabaab", "aabbabaababaabbaabbbabba",
            "abbbabaabababaabababaaaa", "bbaabbabbbabbbaabbbaabbb",
            "baaabbabaabbabbaabbbabbbabbabbbabaabbabababbabbbaabbaaabbbabaaaaaabababababababa",
            "aabaaaabbbbabaababbaabbbaaabbaaababbbbabaaaabbbaaabbbbabbaabaabb", "abaabaaabababbabaaaababb",
            "babaabbbaaababbbbbabaaba", "abbbbabbbaabbbbaabbabaaa", "aabbabaabaabbbaababbabaa",
            "babbbbbbbaabaaababaaabab", "ababbaaabbaabbaababababbbbababbbbbbbabbbaaaaaaab",
            "baaaaabaababbbabbabaaaaaaababbabaaababbabbababbbbabaabba", "baaaaabaaabababbbabaaaaa",
            "bbaaabbababbbbbbaaabaaabbaaaabab", "aaaaaababbabababbbaababa", "abbabbbabaabaaabbbbbbbba",
            "abbbbabbbabbbabaabaaabbbabbbbabbaaabbbabaaaaabba",
            "bbbabaabbabbaababaaaabaabaabbabbaababbbabbaaaaabbbbaababaaababbb", "bbaaaabbabababbbbbbbbaab",
            "baabaaabbabbaabbaabababa", "babbbbbabaabaabbbabaaaaa", "babbbaaaababaabbabbaaaaaaabbbbab",
            "baaabbabbaabaabbabbbaaaaaaaaaabbaaabbbbbbabaabab", "ababaaaaaaaaaaaaababaaaaabaaabab",
            "bbbbbbabaababaabbbaabaabbbababba", "bababaaaaaabaabbbabababa", "bbabababaaabbabaaabbababbbbababb",
            "baabbabaabaabbbabbbaababaaabbabbbabbabbabbabaaaa",
            "abbbabbaabbaabbabbbaabbbbabbbbbaaabbbaabaababbababaaababababaaabbbabbbab",
            "ababbaabbabbaabaabbbbbbbbabaabaabbaaaaabbabababb",
            "abababaabaaaaababaababaaabbaaababbbbabbbbbabaabbabaaababaabbaabbaabaaabb",
            "ababbaababbaaaaabaabbbbbaaaaabaaabbababbbababbbababbaaabbaabbaba", "aabbabbbaaabaabbabaabbbbbbbbbaab",
            "baaaabbaaaababaaabbaabbb", "aababaabbaaabbaaaaaabaababaabbbbbbbbbaaa",
            "bbaabaabbabaaabbbababbababbbabbaaabaabbaabbaaaaaabbbaababbbbabaabbaaaaabbababbaa",
            "aababaabaababaababbaabab", "bbaaababbbbaaaaaabbaabababaaababbbbaabaa", "abbaabbaabbaabbababbabab",
            "babbabaabababaabaababbaaabaabaabaaabaabbabbababbaaabbbbaabbaaaaaaababaab", "ababaaababbbbbbaaababbbb",
            "bbbbbbbababaabaaabbabaab", "baaabaabbabbbbaaaaaaabbb", "ababaabbaaabbabbaaaaabab",
            "bbaabbbaaaaabbabaabbbaba", "abbaaabbbbbbbabbabaabbaababbbbbbbabbababbababbbb",
            "baaaabbaabbaaaabaabbabababaaaaaaabbaabaa", "abbabbbaaaabbaaaabababab", "aabaababababaabbbabbabaa",
            "abaaaabbbaabaaabaaabbbaa", "aabbabbbbbbaaabbaaaabbab", "ababaabbaabbaaaabbaaaaab",
            "abbbbbaabbbbbbbaaabbaabb", "abaabbbaaaabbbbbabaabbab", "babaaabbbabbbbaabaaaaabbbbbabbaabaabbaaa",
            "babaabbbbaababaaaabbaaab", "aaabaaaaaabbbababbbaabbabbabbaab", "aabbabaaababbbaabbaaabab",
            "abbaaaabbabababbbbbbbbbb",
            "baaabbaaababaaaaababaabbbbabbbaabbbaababbabbbbabbaaaabbaaabababbabaaabbababaaaabbaababbb",
            "ababaaabbbbabbbbbaabbabaaaaaabaa", "aaababbaabbababbaababaaabaababbabbbaabaababbabba",
            "baabbbbbabbbbbbaabaabbbbbaaaabbaaabbaabaaabaaabaabaabbab",
            "aabbbbbaaabababbbbbaaabaaababbaabababaabbaabababbaabbabbaabaababbbabbaabaabbaaba",
            "baabaaaaaaaabaababbaabbb", "aabaabbbbabbaabbbaababbb", "abbaaabaaabbabbaaaaaaabbaaaaabab",
            "baabbbbaaaabaaabaaababaaaabbaabb", "abbabbbaabababaaababbbba", "aaaabbbbbbaabbabaabbaabb",
            "baabaaababbbaabaabbbbbaa", "abbaaabaaabaababbbabaaaa", "bbababaaaabaaaabbabbbbbbababbbbbbbbbaabaabbbbaba",
            "aabbbbaaaaaaaababaaababa", "bbbabbabaabaaaabbababaabbbaabaabbbaaaaaaaabbbaabbbbabaab",
            "babababaabbbababbbbbbaaababaaaababbaaabababbaaaaaababbbabbbabaabbaaaababaaaaabbb",
            "aaababbaaabaaabababbaabbbbabababababaaabbbababba", "bbaabbabababaababaaaaaaa", "bbbaababbabbbbbabbbbaaaa",
            "baabbaababbabbbabbaaabbbbbbbaabbbaabaaaabbaabbbb", "ababbbababaabbaabababbab", "aaabbaaaabbaaabbabbaabab",
            "bbaabaaaabaabbbbbbbaabaabbbbbaaabababbbaabbabbbbaababbab", "babbbabababbbababbbabbba",
            "abbbbabbbbababaaabaabaab", "abababbbabbbabaabbbbababababbabaaaabaaaaaaaaaababbbbbaabbaaabbbb",
            "babaabbaaaaabbbbabbbbaab", "baabaabbbabaaaabaabbababbbaaabaa",
            "baaaaaababaaaaaabbaabbabaabbaaaabaaaababbaabaaba", "aabbaaaaabaabbbbabaaaaab",
            "aaababbbabaababbabbbaabbbababaaaaaabbabbbbabbabaabababbbbbbababbabbbbaabbabababb" };

    static {
        Rule[] rules = new Rule[sampleRules.size()];

        for (var rule : sampleRules) {
            rules[rule.ndx] = rule.rule;
        }

        sample = new Notes(Arrays.asList(rules), sampleMsgs);

        rules = new Rule[sample2Rules.size()];

        for (var rule : sample2Rules) {
            rules[rule.ndx] = rule.rule;
        }

        sample2 = new Notes(Arrays.asList(rules), sample2Msgs);

        rules = new Rule[puzzleRules.size()];

        for (var rule : puzzleRules) {
            rules[rule.ndx] = rule.rule;
        }

        puzzle = new Notes(Arrays.asList(rules), puzzleMsgs);
    }
}
