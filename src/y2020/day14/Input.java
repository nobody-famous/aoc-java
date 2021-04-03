package y2020.day14;

public interface Input {
    Op[] sample = new Op[] { new Mask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"), new Memory(8, 11), new Memory(7, 101),
            new Memory(8, 0), };

    Op[] puzzle = new Op[] { new Mask("X00000000000110011100XXX011110111011"), new Memory(41579, 225076),
            new Memory(14806, 26208185), new Memory(47659, 176531392), new Memory(27723, 186971157),
            new Memory(35129, 3483636), new Memory(27142, 4246), new Mask("01101X10101011000101X1X0XXX101111110"),
            new Memory(16685, 392461), new Memory(65343, 13662482), new Memory(53292, 736), new Memory(6830, 382342975),
            new Memory(12777, 19983424), new Memory(19592, 679514970), new Memory(8776, 122013),
            new Mask("011X110100011100111001X1000XX011001X"), new Memory(29076, 305532), new Memory(30139, 135337),
            new Mask("0100X00X1010110X0X010010010001000001"), new Memory(32307, 2921), new Memory(29478, 15201),
            new Mask("1X101101001111111XX1XX1X00X100111X11"), new Memory(35018, 63654376), new Memory(13977, 22331),
            new Memory(7078, 27879686), new Memory(36409, 1248), new Memory(29098, 1049),
            new Mask("010X0001001X111011001011X000X100X010"), new Memory(37355, 3525), new Memory(37012, 16715),
            new Memory(2023, 7212969), new Memory(31805, 455891), new Memory(34394, 411403104),
            new Memory(5056, 14954425), new Memory(55325, 17658), new Mask("01101XX01010X100010XXX011110111X0010"),
            new Memory(60619, 889), new Memory(65362, 145345), new Memory(53540, 2298570), new Memory(62434, 542),
            new Memory(12457, 1279), new Memory(5456, 4090), new Mask("01001X01100010101111X000X01X0X01X001"),
            new Memory(27104, 3012), new Memory(9008, 75), new Memory(31688, 60),
            new Mask("XX01X00000XX110011100X0X010110XX1100"), new Memory(25251, 7374), new Memory(63139, 27875755),
            new Memory(42967, 8204614), new Memory(61987, 396), new Memory(30866, 691),
            new Mask("1001000X00X0110X1110001000100101XX00"), new Memory(40705, 21726765), new Memory(7454, 22726),
            new Memory(46834, 68819), new Memory(7078, 643555271), new Memory(48619, 34299689),
            new Memory(42749, 27406055), new Memory(32511, 54957378), new Mask("0X0110010011X1X0110000001010000100X0"),
            new Memory(5752, 957), new Memory(58252, 463561556), new Mask("0X1X1X010011110X111001X00001000XX0X0"),
            new Memory(63353, 14516), new Memory(15823, 2060), new Memory(30126, 102554), new Memory(30621, 17543629),
            new Memory(35116, 76250), new Memory(10236, 11446819), new Memory(16660, 2541872),
            new Mask("1X01X00000101100X1X01111100101100000"), new Memory(48609, 312842), new Memory(2909, 17774),
            new Memory(19872, 5613), new Memory(9985, 6539455), new Memory(63287, 312743), new Memory(40351, 16889429),
            new Mask("0111001001111110XXXX0XXXX11100010011"), new Memory(61065, 14018), new Memory(1689, 301351825),
            new Memory(31135, 568), new Mask("X10000100010X000111001X0X0010010X00X"), new Memory(29969, 7096617),
            new Memory(19809, 862281685), new Memory(30350, 1871), new Memory(31001, 93711152),
            new Memory(13233, 33263717), new Memory(42482, 579908), new Mask("01X10X0X00X11100110100011X0X0X0X001X"),
            new Memory(41248, 7946615), new Memory(1829, 1576), new Memory(907, 21637953), new Memory(3566, 2883),
            new Memory(29687, 19408), new Memory(15657, 972), new Mask("010100X10001110010X110X01X0111X01010"),
            new Memory(53292, 609), new Memory(55550, 8115727), new Memory(834, 617), new Memory(53708, 498838597),
            new Memory(39044, 309), new Memory(17842, 5862), new Mask("0100X00010X011X01110X0XX0110000X1101"),
            new Memory(32511, 50674184), new Memory(41256, 996258), new Memory(47199, 1837),
            new Mask("1101001XXX1X111X10X00X000X011101X101"), new Memory(9292, 623250), new Memory(45902, 258279925),
            new Memory(20440, 172992884), new Memory(31688, 65210), new Memory(2288, 66034927),
            new Mask("01100101X110X01X11X01100001000X11001"), new Memory(58893, 2144468), new Memory(5048, 750616856),
            new Mask("010110X1001111001100XX0011100101X0X0"), new Memory(9150, 4201416), new Memory(33664, 15504),
            new Memory(7218, 18606957), new Mask("01X1100X0X00110011X0101101111X0X1111"), new Memory(8003, 1403),
            new Memory(64683, 16052434), new Memory(17299, 43327), new Memory(13505, 961), new Memory(48609, 709578),
            new Memory(11582, 855), new Memory(42822, 3983), new Mask("01101001X01X11X011XX0111110110000101"),
            new Memory(30603, 24703071), new Memory(3805, 775231), new Memory(30098, 230279), new Memory(46351, 5983),
            new Memory(6689, 3542), new Memory(26816, 121693), new Mask("1X00X0101010010011X1XX0110110011X0X1"),
            new Memory(16838, 192956313), new Memory(60531, 24171693), new Memory(22819, 38459),
            new Memory(26453, 6160088), new Mask("1X010X000000110X1110100001X0100100X0"), new Memory(43837, 22192131),
            new Memory(10090, 21946), new Mask("01X111000X011100111XX100001100100000"), new Memory(4306, 56171106),
            new Memory(50905, 3399), new Memory(36168, 121097), new Mask("1X010000XXX111001X100X100100X0X001X1"),
            new Memory(31394, 121478), new Memory(4906, 139929), new Memory(36356, 1924),
            new Mask("1010X010001011X011X011XX11011110X111"), new Memory(11864, 29928714), new Memory(30866, 45934),
            new Memory(19873, 370711), new Mask("0101100000X10110111110X0XXX1XX110X01"), new Memory(51120, 65808488),
            new Memory(22318, 10244125), new Memory(26453, 13126923), new Memory(64961, 3880),
            new Mask("X01011X1001111X1X11XX100010X00111100"), new Memory(62778, 126882), new Memory(59733, 1267462),
            new Memory(13740, 435), new Memory(3400, 8477), new Memory(4133, 116701), new Memory(30619, 231703),
            new Mask("01000X011010101011110X1000110XX0110X"), new Memory(45164, 25402465), new Memory(9309, 77050566),
            new Memory(29909, 706), new Memory(27758, 1319), new Memory(6150, 106196666),
            new Mask("01X11X0X00X111001110X1XX0001X001001X"), new Memory(14255, 13708852), new Memory(513, 3790644),
            new Memory(28804, 395377671), new Memory(57953, 72417), new Memory(28725, 1201), new Memory(11750, 233),
            new Mask("X10100X100111110110X00001X1011010X11"), new Memory(49595, 24812), new Memory(64152, 9382),
            new Memory(12122, 2319571), new Memory(42088, 482), new Mask("1X000XX010100100111100X001110X1000XX"),
            new Memory(13636, 524153304), new Memory(36450, 352968), new Memory(6260, 4407821),
            new Mask("0111000X000101X01XX100X1X1001110X010"), new Memory(7218, 94415), new Memory(29864, 5120026),
            new Memory(53070, 6612), new Memory(36573, 8326010), new Memory(1987, 5992534), new Memory(9798, 11713),
            new Mask("110000X01010X100111100X01011000XX10X"), new Memory(26267, 61334), new Memory(29687, 520585578),
            new Memory(11781, 66211489), new Mask("X001X000000111001110X011001X1X100011"), new Memory(2023, 805),
            new Memory(7673, 1711), new Memory(9374, 7545), new Memory(45925, 33575),
            new Mask("010X000X10101X000011XXX00X1000000000"), new Memory(30922, 12722836), new Memory(61189, 510395),
            new Memory(26267, 38479500), new Mask("X0101X0100X11X1110X11110000000X01011"), new Memory(55014, 27563943),
            new Memory(46994, 497673195), new Memory(43529, 80791407), new Memory(65052, 454391739),
            new Memory(30577, 304), new Mask("0X01000110011X00X10110111100X0X10010"), new Memory(45248, 7792707),
            new Memory(6927, 12193), new Memory(60386, 3927747), new Memory(39315, 4161237),
            new Mask("X001X01000X01100111010101X111X1X0010"), new Memory(15099, 17870434), new Memory(60, 32347),
            new Memory(6193, 412046876), new Memory(61561, 142217182), new Memory(25826, 2073043),
            new Memory(61322, 14525), new Mask("X1X100X0X11111X01XX000000101000X1X01"), new Memory(4794, 233038),
            new Memory(29193, 23211308), new Memory(26267, 10247786), new Memory(44728, 384574), new Memory(57840, 471),
            new Memory(23517, 507429935), new Memory(8408, 251968), new Mask("X1000X010010110X11X100101X1X1101X100"),
            new Memory(14979, 52721), new Memory(14121, 12422), new Memory(65343, 653), new Memory(513, 23189896),
            new Mask("1101X0X0010X110010100111101000X00XX0"), new Memory(21511, 30489818), new Memory(63139, 13245573),
            new Memory(64852, 762), new Mask("XX01100000011100111X11X00100110X0111"), new Memory(59229, 47739),
            new Memory(49595, 31185), new Memory(9374, 11755159), new Memory(42415, 206175),
            new Mask("X1X010X01010X10001X1010100X1X1X10X10"), new Memory(65383, 54664), new Memory(17412, 6631),
            new Memory(55994, 373011), new Memory(53672, 26530655), new Memory(7974, 1007816675),
            new Mask("1100X010X01X1000111001X100011011000X"), new Memory(4896, 38031019), new Memory(754, 2287),
            new Memory(30181, 50259322), new Mask("1X010XX00XX111001X10X110100X10000100"), new Memory(32551, 7983378),
            new Memory(7438, 31324924), new Mask("0101X0000010X100111000X0X1X110X01110"), new Memory(25209, 48369038),
            new Memory(50393, 576369), new Memory(40859, 3812), new Memory(56386, 569373625),
            new Memory(63105, 8734731), new Mask("10101XX0001011X01110XX001X010110XX0X"), new Memory(34042, 19350728),
            new Memory(32063, 255940784), new Memory(33476, 53404), new Memory(35243, 209057823),
            new Memory(4983, 377086), new Memory(4794, 16200733), new Mask("01X01000101X110001010X11X01X00000101"),
            new Memory(19467, 14126078), new Memory(29699, 830), new Mask("010110X000X1X110111XX1001111X0X10XX1"),
            new Memory(43026, 13471405), new Memory(4984, 1882), new Memory(18947, 15001421),
            new Mask("XX011001X0XXXX001X1101X0000100001010"), new Memory(55787, 737), new Memory(1563, 2538),
            new Memory(59758, 28003877), new Mask("100X000X000X110X1X101100001011X1X011"), new Memory(25696, 172112),
            new Memory(12279, 113288), new Memory(24031, 37612590), new Mask("11XX00X00010110011100101X11010100111"),
            new Memory(46130, 1530), new Memory(12542, 795), new Mask("110X00011X01111001X00X1100100010XX10"),
            new Memory(27592, 128275), new Memory(27809, 132195912), new Memory(24738, 199737),
            new Memory(19162, 15356), new Mask("010001010X10X10X1111000010001101X000"), new Memory(8268, 377409380),
            new Memory(10236, 540166), new Memory(38723, 139937), new Memory(60530, 7895799),
            new Memory(21813, 6275543), new Memory(8917, 50534988), new Memory(50461, 251351),
            new Mask("0110X1011XX01X1011X0X1010X11X000X000"), new Memory(37937, 2706), new Memory(53672, 23428),
            new Memory(16637, 43775004), new Memory(13789, 23884648), new Mask("1X0X00X0001011001110000101X1X1X0X0X1"),
            new Memory(55787, 960988), new Memory(29687, 510439), new Memory(63862, 122580), new Memory(30126, 1488),
            new Memory(44826, 3558), new Mask("XX00001010X011001X110X0X11XX10000X00"), new Memory(5760, 209762),
            new Memory(27142, 2968), new Memory(19789, 269), new Memory(634, 9949),
            new Mask("01X0X00010101100X1X101XX01110X0X011X"), new Memory(24659, 304), new Memory(28725, 7064540),
            new Memory(23533, 396592131), new Memory(42715, 129702313),
            new Mask("1X0X0000X0X0110011101X10011X1110000X"), new Memory(31688, 698304069), new Memory(28880, 1648),
            new Memory(1915, 1894), new Memory(50253, 3317783), new Mask("0101X00100X1110011XX00X00X00X00XX010"),
            new Memory(7930, 49938921), new Memory(45686, 376), new Memory(44994, 394081142), new Memory(25475, 1655),
            new Memory(11478, 704), new Memory(34150, 4147579), new Mask("X10X00X0011X11001X100100011100000011"),
            new Memory(13838, 9047), new Memory(64712, 7762), new Memory(63477, 6690357), new Memory(38863, 7288),
            new Mask("01000000101011000X11011XX111000X01X1"), new Memory(20533, 10736847), new Memory(40924, 430217452),
            new Memory(64360, 2426851), new Memory(58115, 12071761), new Memory(30126, 26562102),
            new Memory(6672, 154543), new Memory(4382, 10121), new Mask("01X110X00X1X11101X10X110011100X00011"),
            new Memory(20472, 194), new Memory(35111, 708430742), new Memory(2674, 44), new Memory(39452, 614),
            new Memory(19219, 110991746), new Mask("01X10X010001X1001XX1X00000X00X000110"),
            new Memory(38888, 996404203), new Memory(13988, 2030), new Memory(29687, 833197),
            new Mask("X0010000X00X11X001X000X001011XX1X001"), new Memory(19041, 26558), new Memory(57953, 30524),
            new Memory(58714, 3716054), new Memory(12930, 83910), new Mask("1101100X0X111X001X10XX1101011X100000"),
            new Memory(45686, 3647), new Memory(33541, 36310663), new Memory(17979, 6056054), new Memory(10534, 16345),
            new Memory(47111, 232953370), new Memory(25533, 27557895), new Memory(58098, 1560064),
            new Mask("100X0000X0X011XX11X001000101111X0000"), new Memory(26199, 246090059), new Memory(18199, 88594470),
            new Memory(29909, 16759), new Memory(64360, 634531), new Mask("0101XXX10011110XX1100011000X001101X0"),
            new Memory(16673, 22927535), new Memory(12390, 62487), new Memory(60131, 719), new Memory(20196, 175993),
            new Memory(34150, 25943355), new Memory(9914, 48537509), new Memory(41065, 46726),
            new Mask("0101000100X11100XX01000X101001000000"), new Memory(61353, 192), new Memory(30126, 122504373),
            new Memory(43978, 112475), new Memory(54606, 262832639), new Mask("110000X01XX0010X1111011010XX01110100"),
            new Memory(38654, 5670), new Memory(19246, 3500), new Memory(3280, 780682), new Memory(25841, 3675082),
            new Memory(10090, 939), new Memory(30577, 19385), new Mask("1101X000001X11XX1110010101101X101X01"),
            new Memory(30181, 467224373), new Memory(64712, 19540), new Memory(9150, 110790020), new Memory(58763, 649),
            new Memory(61987, 31515335), new Memory(36168, 40664), new Mask("011001X1X10010X01X1X0X010100X101X1X1"),
            new Memory(50341, 249123925), new Memory(57809, 1245764), new Memory(1000, 6880),
            new Memory(62447, 9704635), new Memory(57040, 22401), new Memory(36847, 1403),
            new Mask("1XX0X01000101XX0111001X00101110XX101"), new Memory(44459, 1909253), new Memory(28804, 13248),
            new Mask("11000000X010X1001110111XX0100X101000"), new Memory(44826, 1584), new Memory(8549, 20390300),
            new Memory(8024, 83478929), new Memory(26411, 1612730), new Memory(27809, 3340355),
            new Mask("0101100X00X111X0111XX100X010000100X1"), new Memory(43026, 246196988), new Memory(3889, 148865),
            new Memory(43538, 168294874), new Memory(37181, 2452), new Memory(13074, 203182),
            new Mask("100100100101110011X0XX10X101101XX100"), new Memory(47655, 2283), new Memory(43365, 51654102),
            new Memory(20448, 1899), new Memory(46501, 866), new Memory(39220, 8179259),
            new Mask("01100101111X11XX1X00X100000X0110XX00"), new Memory(4063, 25905), new Memory(56197, 7616),
            new Memory(22101, 96196611), new Mask("XX011100X001110X1110XX000X1010000010"), new Memory(38766, 317650050),
            new Memory(275, 1077), new Memory(47272, 3545), new Memory(17513, 428), new Memory(31209, 10901538),
            new Memory(60020, 8191405), new Mask("100X0000X0001100X110XXX00001110X000X"), new Memory(3889, 240406519),
            new Memory(58283, 105792011), new Memory(2023, 11451400), new Memory(42056, 500252),
            new Mask("0101100100X11X00110100X001001X0000X0"), new Memory(51566, 18992), new Memory(2207, 9397005),
            new Memory(16208, 18748), new Memory(11287, 117402894), new Memory(10310, 16126), new Memory(63935, 59804),
            new Mask("X1X00X01101011X011XX1001011X10110X01"), new Memory(17412, 292), new Memory(55917, 290254),
            new Memory(36766, 38849561), new Memory(39220, 401237793), new Mask("011001011X1011X01X100001000110010X00"),
            new Memory(41854, 1014518), new Memory(16822, 16372), new Memory(36517, 6130231),
            new Memory(37271, 406796637), new Mask("0X01000X000111X0111X011001X000000X11"), new Memory(58255, 95641),
            new Memory(98, 61432470), new Mask("0100000100101XX01111100100X11X011101"), new Memory(9985, 1592325),
            new Memory(11478, 2271665), new Memory(3757, 41068007), new Memory(61585, 70572), new Memory(17154, 335361),
            new Memory(60531, 41930933), new Mask("1001X00000X011011110X0100X000X010010"), new Memory(64462, 29767556),
            new Memory(24738, 210929), new Memory(50899, 1287), new Mask("000XX000000111100100X10001X10010100X"),
            new Memory(6334, 287), new Memory(34777, 1860550), new Mask("110X001000101X001110X111010X0X1X0X01"),
            new Memory(12157, 6178), new Memory(40351, 59493), new Memory(30619, 34292339), new Memory(13636, 1290347),
            new Mask("X100000XX01011X0111X100101000X10X1X1"), new Memory(60731, 9983015), new Memory(9985, 18414272),
            new Memory(56154, 62268050), new Memory(40924, 15580622), new Mask("01010001XX011100110110100X00XX010000"),
            new Memory(24823, 113683), new Memory(33142, 14761835), new Memory(33664, 26275), new Memory(7822, 5148968),
            new Memory(39411, 1216069), new Memory(27779, 102128), new Memory(36065, 10811),
            new Mask("11X00010XX10100011X00001X11X0X1X10X1"), new Memory(34192, 592942932), new Memory(61987, 27192613),
            new Memory(63760, 8016), new Mask("010XX00110X01X101111100X0X100X100001"), new Memory(14125, 363398),
            new Memory(9080, 113944), new Memory(29909, 14606451), new Memory(52829, 102953),
            new Mask("0101XX01001111X0110X0010XX0001011110"), new Memory(8212, 2171), new Memory(60531, 439001),
            new Memory(11151, 8267), new Memory(634, 51725), new Memory(38040, 6915656),
            new Mask("XX01001X011X1X001000011100100X000101"), new Memory(18184, 34766), new Memory(53526, 38417257),
            new Memory(28494, 114210018), new Memory(102, 3422103), new Mask("X100000010101100X1110XXX01110000X1X1"),
            new Memory(7454, 3185), new Memory(45157, 3488), new Memory(62822, 3659366),
            new Mask("1110100X1010110001X1X11X1001X0X1001X"), new Memory(58002, 236109549), new Memory(3536, 11719),
            new Memory(40939, 550805420), new Memory(34751, 538), new Memory(51410, 19066), new Memory(11996, 29329688),
            new Mask("01010XX00001111011X00110010X0010X111"), new Memory(64654, 1185760), new Memory(56361, 13297936),
            new Memory(102, 3966), new Memory(18335, 470391), new Memory(1905, 25790),
            new Mask("X10X000110XX1110X11001000X00101001X0"), new Memory(55089, 17943368), new Memory(40456, 501700825),
            new Memory(47927, 513748), new Memory(13838, 385), };
}
