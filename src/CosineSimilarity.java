
public class CosineSimilarity {

	public CosineSimilarity() {
		// TODO Auto-generated constructor stub
	}

    /**
     * Method to calculate cosine similarity between two documents.
     * @param docVector1 : document vector 1 (a)
     * @param docVector2 : document vector 2 (b)
     * @return 
     */
	public double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;

        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)

        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
	
	 /**
     * Method to calculate cosine similarity between two documents.
     * @param docVector1 : document vector 1 (a)
     * @param docVector2 : document vector 2 (b)
     * @return 
     */
	public double cosineSimilarity(Double[] docVector1, Double[] docVector2) {
		Double dotProduct = 0.0;
		Double magnitude1 = 0.0;
		Double magnitude2 = 0.0;
		Double cosineSimilarity = 0.0;

        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)

        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
	
	
	public static void main(String[] args) {
		
		
		CosineSimilarity cs = new CosineSimilarity();
		
		double[] a = {100,39999,200};
		double[] b = {500,40000,100};
		
		/*
		double[] p9 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.009052132,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.069424684,0.0,0.0,0.001226709,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.00287547,0.010074431,0.0,0.0,0.0,0.006998,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,4.58382E-4,0.0,0.0,0.015111646,0.0,0.0,0.0,0.0,0.0,0.001805918,0.0,0.0,0.0,0.0,0.007223671,0.0,0.0,0.0,0.0,0.0,0.0,0.004240281,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.022460715,0.0,0.0};
		double[] p10 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.015988421,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.040130854,0.0,0.024139025,0.001181829,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.00554054,0.009705854,0.0,0.0,0.0,0.026967901,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.002208059,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.008699238,0.0,0.0,0.0,0.0,0.0,0.0,0.002042574,0.0,0.0,0.0,0.0,0.0,0.013376951,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.016781251,0.0,0.0};
		double[] p11 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.008363958,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.026044738,0.001700176,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007970601,0.0,0.0,0.0,0.0,0.019397964,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.001270603,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.022526448,0.038488071,0.0,0.0,0.0,0.017520571,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.012706025,0.0,0.0};
		double[] p12 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.008513315,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.026509823,0.001730536,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.009465089,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.001293292,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.017833438,0.039175358,0.0,0.0,0.0,0.017833438,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.013579565,0.0,0.0};			
		double[] p13 = {0.0,0.0,0.008447878,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.025650275,0.010934533,0.0,0.0,0.0,0.0,0.0,0.0,0.016895757,0.0,0.0,0.0,0.004539908,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006946854,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,9.96665E-4,0.0,0.0,0.0,0.006412569,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.023559771,0.0,0.0,0.020287779,0.016895757,0.0,0.0,0.001536615,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.017275532,0.0,0.0};
		double[] p14 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.013242934,0.0,0.0,0.0,0.0,0.031065334,0.0,0.0,0.0,0.0,0.0,0.0,0.004307112,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.008413413,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.031065334,0.0,0.0,0.0,0.00482829,0.0,0.0,0.0,0.015532667,0.0,0.0,0.0,0.0,0.015851945,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003722024,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.012070724,0.0,0.0};
		double[] p15 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006252259,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.045094839,0.012213018,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.001168135,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.041419598,0.0,0.0,0.017833612,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.035384194,0.0,0.0,0.0,0.0,0.010513211,0.0,0.0};
		double[] p16 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.004584093,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007454616,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.002912335,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.008356655,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.053766923,0.0,0.0,0.0,0.0,0.0,0.01288393,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.01671331,0.0,0.0};
		double[] p17 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.019864401,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.041237502,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.033161667,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.033161667,0.174742501,0.0,0.0,0.0,0.0,0.017833438,0.0,0.0,0.0,0.0,0.005944479,0.0,0.0,0.0,0.0,0.0,0.0,0.006978795,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.004526522,0.0,0.0};
		double[] p18 = {0.0,0.0,0.0069759,0.0,0.0,0.0,0.0,0.0,0.010590455,0.0,0.0,0.0,0.0,0.014446837,0.0,0.0,0.0,0.0,0.0,0.0,0.0069759,0.0,0.0,0.0,0.0,7.34167E-4,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.013767403,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.001646008,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006484887,0.0,0.0,0.0,0.0,0.024858732,0.0,0.016619849,0.004188197,0.0,0.0,0.0,0.001268872,0.0,0.0,0.0,0.0,0.0,0.008309924,0.0,0.0,0.0,0.0,0.0,0.0069759,0.0,0.0,0.0,0.0,0.0,0.012619394,0.0,0.0};
		*/
	
		double[] p45 = {0.0,0.0,0.007172682,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.055723372,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007172682,0.0,0.005196763,0.0,0.003011028,0.0,0.001074125,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0229485,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.00281815,0.0,0.0,0.0,0.0,0.003293647,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007845912,0.0,0.0,0.0,0.0,0.018620108,0.03790541,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.031299896,0.0,0.0,0.0,0.0,0.0};
				double[] p46 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.034969259,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.005668722,0.0,0.001348136,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.028802709,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003602799,0.0,0.0,0.0,0.001768533,0.0,0.0,0.0,0.0,0.004133863,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006154638,0.0,0.0,0.0,0.0,0.010516561,0.04559286,0.0,0.00566205,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.00801357,0.0,0.0,0.0,0.0,0.011085304,0.0,0.036973707,0.0,0.0,0.0,0.0,0.0};
				double[] p47 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.021100138,0.0,0.039578907,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007964656,0.0,7.10308E-4,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.021012398,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003796498,0.0,0.0,0.0,3.72723E-4,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006485532,0.0,0.0,0.0,0.0,0.008619308,0.053266272,0.0,0.005966461,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.004222203,0.0,0.0,0.0,0.0,0.0,0.0,0.038352766,0.0,0.0,0.0,0.0,0.0};
				double[] p48 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.046487404,0.0,0.006733754,0.0,0.001201067,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.035530055,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003151204,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.024126179,0.0,0.0,0.0,0.0,0.014574467,0.040619093,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.019751997,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.033969593,0.0,0.0,0.0,0.0,0.0};
				double[] p49 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.014645245,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.043023198,0.0,0.00712224,0.0,0.002540718,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.041755406,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.001999803,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.020878424,0.0,0.0,0.0,0.0,0.01101093,0.026151088,0.010445768,0.005335393,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.037018146,0.0,0.0,0.0,0.0,0.0};
				double[] p50 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.011375727,0.0,0.0,0.022073993,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.010289303,0.0,0.0,0.0,0.0,0.003446539,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.015104564,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007836908,0.0,0.0,0.0,0.0,0.010568311,0.017516149,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.033566858,0.0,0.0,0.0,0.0,0.0,0.028717468,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.040369661,0.0,0.0,0.0,0.0,0.0};
				double[] p51 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006573912,0.0,0.0,0.034442084,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.00594608,0.016060347,0.0,0.001861088,0.0,0.001327812,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.006573912,0.031641785,0.043672757,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.005573989,0.0,0.0,0.0,0.0,0.006107315,0.04555079,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007274225,0.0,0.0,0.0,0.0,0.018414258,0.007809657,0.010918189,0.005576693,0.0,0.0,0.0,0.0,0.0,0.02691452,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003946381,0.0,0.0,0.0,0.0,0.0,0.0,0.033002285,0.0,0.0,0.0,0.0,0.0};

		
		
		double[] p59 = {0.0,0.0,0.003786437,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.012740771,0.0,0.0,0.0,0.0,0.0,0.0,0.045758535,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.02140139,0.0,0.007572874,0.005078411,0.0,0.0,0.004768538,0.0,5.67027E-4,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.020501367,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.030306806,0.0,0.0,0.0,0.00416554,0.0,0.0,0.0,0.0,0.001738706,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.007248208,0.0,0.0,0.0,0.0,0.017693099,0.022511421,0.0,0.002381463,0.012967965,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.003370514,0.0,0.0,0.028073145,0.0,0.0,0.0,0.032074294,0.0,0.0,0.0,0.0,0.0};
		double[] p60 = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.086540086,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.012336824,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.002363403,0.0,0.0,0.0,0.0,0.009207241,0.034335634,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.002741611,0.0,0.0,0.0,0.0,0.010410333,0.041943629,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.027021267,0.0,0.0,0.0,0.0,0.0};

		
		System.out.println(cs.cosineSimilarity(p59,p45));
		System.out.println(cs.cosineSimilarity(p59,p46));
		System.out.println(cs.cosineSimilarity(p59,p47));
		System.out.println(cs.cosineSimilarity(p59,p48));
		System.out.println(cs.cosineSimilarity(p59,p49));
		System.out.println(cs.cosineSimilarity(p59,p50));
		
		System.out.println();
		
		System.out.println(cs.cosineSimilarity(p60,p45));
		System.out.println(cs.cosineSimilarity(p60,p46));
		System.out.println(cs.cosineSimilarity(p60,p47));
		System.out.println(cs.cosineSimilarity(p60,p48));
		System.out.println(cs.cosineSimilarity(p60,p49));
		System.out.println(cs.cosineSimilarity(p60,p50));
		
		
	}

}