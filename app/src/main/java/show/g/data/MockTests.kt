package show.g.data

import show.g.model.BioTest
import show.g.model.Question

private fun q(prompt: String, options: List<String>, correctIndex: Int): show.g.model.Question =
    Question(
        prompt = prompt,
        options = options,
        correctIndex = correctIndex
    )

val MockTests: List<BioTest> = listOf(
    BioTest(
        id = "t_cell_basics",
        title = "Cell Basics",
        description = "Test your knowledge of cells, the building blocks of life.",
        iconKey = "cell",
        questions = listOf(
            q(
                "Which organelle is known as the powerhouse of the cell?",
                listOf("Nucleus", "Mitochondrion", "Ribosome", "Lysosome"), 1
            ),
            q(
                "Plant cells contain a structure that animal cells lack. What is it?",
                listOf("Nucleus", "Cell wall", "Golgi apparatus", "Smooth ER"), 1
            ),
            q(
                "Which molecule makes up the bulk of a cell membrane?",
                listOf("Proteins", "Phospholipids", "Cholesterol only", "Carbohydrates"), 1
            ),
            q(
                "Ribosomes are mainly responsible for:",
                listOf("Energy storage", "Protein synthesis", "DNA replication", "Waste disposal"),
                1
            ),
            q(
                "Which process describes cells dividing to form two identical cells?",
                listOf("Meiosis", "Mitosis", "Fertilization", "Budding"), 1
            ),
            q(
                "The control center of a eukaryotic cell is the:",
                listOf("Chloroplast", "Nucleus", "Vacuole", "Peroxisome"), 1
            ),
            q(
                "Which organelle packages proteins for export?",
                listOf("Golgi apparatus", "Nucleolus", "Centrosome", "Endosome"), 0
            ),
            q(
                "A selectively permeable membrane allows:",
                listOf(
                    "Everything to pass",
                    "Nothing to pass",
                    "Only certain molecules to pass",
                    "Only water to pass"
                ), 2
            ),
        )
    ),
    BioTest(
        id = "t_genetics_fund",
        title = "Genetics Fundamentals",
        description = "From Mendel's peas to modern inheritance rules.",
        iconKey = "dna",
        questions = listOf(
            q(
                "DNA is made up of building blocks called:",
                listOf("Amino acids", "Nucleotides", "Fatty acids", "Monosaccharides"), 1
            ),
            q(
                "An organism with two different alleles for a trait is called:",
                listOf("Homozygous", "Heterozygous", "Recessive", "Dominant"), 1
            ),
            q(
                "How many chromosomes are in a normal human body cell?",
                listOf("23", "46", "48", "92"), 1
            ),
            q(
                "A sudden change in a DNA sequence is called a:",
                listOf("Mutation", "Translation", "Translocation", "Replication"), 0
            ),
            q(
                "Gregor Mendel studied inheritance using:",
                listOf("Fruit flies", "Pea plants", "Mice", "Bacteria"), 1
            ),
            q(
                "Sex chromosomes in a typical human female are:",
                listOf("XY", "XX", "XO", "YY"), 1
            ),
            q(
                "The physical expression of a genotype is the:",
                listOf("Allele", "Phenotype", "Locus", "Codon"), 1
            ),
            q(
                "A Punnett square is used to predict:",
                listOf("Cell size", "Protein shape", "Genetic outcomes", "Enzyme activity"), 2
            ),
        )
    ),
    BioTest(
        id = "t_human_bones",
        title = "Human Bones",
        description = "Names, places, and roles of the skeletal system.",
        iconKey = "bone",
        questions = listOf(
            q(
                "How many bones does an adult human skeleton typically have?",
                listOf("186", "206", "226", "246"), 1
            ),
            q(
                "The longest bone in the human body is the:",
                listOf("Tibia", "Humerus", "Femur", "Radius"), 2
            ),
            q(
                "Which bone protects the brain?",
                listOf("Rib", "Cranium", "Sternum", "Pelvis"), 1
            ),
            q(
                "The collarbone is also called the:",
                listOf("Scapula", "Clavicle", "Sternum", "Patella"), 1
            ),
            q(
                "The kneecap is formally known as the:",
                listOf("Patella", "Tarsal", "Phalanx", "Fibula"), 0
            ),
            q(
                "Which of these is NOT part of the vertebral column?",
                listOf("Cervical", "Thoracic", "Lumbar", "Hepatic"), 3
            ),
            q(
                "Red blood cells are produced mainly in the:",
                listOf("Liver", "Bone marrow", "Kidneys", "Spleen"), 1
            ),
            q(
                "The smallest bones in the body are found in the:",
                listOf("Hand", "Foot", "Ear", "Nose"), 2
            ),
        )
    ),
    BioTest(
        id = "t_human_muscles",
        title = "Human Muscles",
        description = "Types of muscle tissue and how they move the body.",
        iconKey = "muscle",
        questions = listOf(
            q(
                "Which muscle type is under voluntary control?",
                listOf("Cardiac", "Smooth", "Skeletal", "None"), 2
            ),
            q(
                "The largest muscle in the human body is the:",
                listOf("Biceps", "Gluteus maximus", "Pectoralis major", "Sartorius"), 1
            ),
            q(
                "Cardiac muscle is found only in the:",
                listOf("Lungs", "Stomach", "Heart", "Diaphragm"), 2
            ),
            q(
                "Muscles are attached to bones by:",
                listOf("Ligaments", "Tendons", "Cartilage", "Fascia"), 1
            ),
            q(
                "Muscle fatigue is often linked to buildup of:",
                listOf("Glucose", "Lactic acid", "Sodium", "Water"), 1
            ),
            q(
                "A muscle that straightens a joint is called a(n):",
                listOf("Flexor", "Extensor", "Rotator", "Abductor"), 1
            ),
            q(
                "Smooth muscle is typically found in:",
                listOf("Biceps", "Walls of organs", "Diaphragm", "Eyelids"), 1
            ),
            q(
                "ATP is used in muscle contraction to:",
                listOf("Cool the cell", "Power filament sliding", "Build DNA", "Store oxygen"), 1
            ),
        )
    ),
    BioTest(
        id = "t_nervous",
        title = "Nervous System",
        description = "Neurons, signals, and the brain's architecture.",
        iconKey = "brain",
        questions = listOf(
            q(
                "The basic functional unit of the nervous system is the:",
                listOf("Axon", "Neuron", "Synapse", "Dendrite"), 1
            ),
            q(
                "Which part of the brain controls balance and coordination?",
                listOf("Cerebrum", "Cerebellum", "Medulla", "Thalamus"), 1
            ),
            q(
                "The gap between two neurons is called the:",
                listOf("Node", "Axon hillock", "Synapse", "Ganglion"), 2
            ),
            q(
                "Sensory neurons carry signals:",
                listOf(
                    "Away from the CNS",
                    "Toward the CNS",
                    "Inside the brain only",
                    "Between muscles"
                ), 1
            ),
            q(
                "The myelin sheath's main role is to:",
                listOf(
                    "Produce ATP",
                    "Speed up nerve impulses",
                    "Store neurotransmitters",
                    "Detect light"
                ), 1
            ),
            q(
                "Reflex arcs are often processed by the:",
                listOf("Cerebrum", "Spinal cord", "Hypothalamus", "Pituitary"), 1
            ),
            q(
                "Which is a neurotransmitter?",
                listOf("Hemoglobin", "Dopamine", "Keratin", "Insulin"), 1
            ),
            q(
                "The brain and spinal cord together form the:",
                listOf("PNS", "CNS", "ANS", "ENS"), 1
            ),
        )
    ),
    BioTest(
        id = "t_plants",
        title = "Plant Life",
        description = "Structure, growth, and function of plants.",
        iconKey = "leaf",
        questions = listOf(
            q(
                "Plants make their own food through:",
                listOf("Respiration", "Photosynthesis", "Digestion", "Fermentation"), 1
            ),
            q(
                "The green pigment in plants is called:",
                listOf("Carotene", "Chlorophyll", "Xanthophyll", "Melanin"), 1
            ),
            q(
                "Water is absorbed by the plant primarily through:",
                listOf("Leaves", "Roots", "Flowers", "Stems"), 1
            ),
            q(
                "Which tissue transports water in plants?",
                listOf("Phloem", "Xylem", "Cambium", "Cortex"), 1
            ),
            q(
                "Tiny pores on leaves that allow gas exchange are:",
                listOf("Stomata", "Lenticels", "Trichomes", "Cuticles"), 0
            ),
            q(
                "The male reproductive part of a flower is the:",
                listOf("Pistil", "Stamen", "Sepal", "Ovary"), 1
            ),
            q(
                "Seeds are typically produced inside the:",
                listOf("Root", "Stem", "Fruit", "Leaf"), 2
            ),
            q(
                "Trees that lose leaves seasonally are called:",
                listOf("Evergreen", "Deciduous", "Coniferous", "Mossy"), 1
            ),
        )
    ),
    BioTest(
        id = "t_photosynthesis",
        title = "Photosynthesis",
        description = "How plants turn sunlight into chemical energy.",
        iconKey = "sun",
        questions = listOf(
            q(
                "Photosynthesis mainly takes place in the:",
                listOf("Mitochondria", "Chloroplasts", "Ribosomes", "Vacuoles"), 1
            ),
            q(
                "The raw materials for photosynthesis are:",
                listOf(
                    "Oxygen and sugar",
                    "CO2 and water",
                    "Glucose and ATP",
                    "Nitrogen and water"
                ), 1
            ),
            q(
                "One product of photosynthesis, besides glucose, is:",
                listOf("Carbon dioxide", "Oxygen", "Nitrogen", "Methane"), 1
            ),
            q(
                "Light-dependent reactions occur in the:",
                listOf("Stroma", "Thylakoid membrane", "Cytosol", "Matrix"), 1
            ),
            q(
                "The Calvin cycle takes place in the:",
                listOf("Stroma", "Thylakoid", "Nucleus", "Cell wall"), 0
            ),
            q(
                "Which pigment absorbs mostly blue and red light?",
                listOf("Carotene", "Chlorophyll a", "Phycoerythrin", "Melanin"), 1
            ),
            q(
                "The overall equation of photosynthesis produces:",
                listOf("Only oxygen", "Glucose and oxygen", "Only water", "ATP only"), 1
            ),
            q(
                "Photosynthesis is an example of a(n):",
                listOf(
                    "Exothermic reaction",
                    "Endothermic reaction",
                    "Neutral reaction",
                    "Combustion"
                ), 1
            ),
        )
    ),
    BioTest(
        id = "t_microorg",
        title = "Microorganisms",
        description = "Bacteria, viruses, fungi, and the microscopic world.",
        iconKey = "microbe",
        questions = listOf(
            q(
                "Which of these is NOT a living cell?",
                listOf("Bacterium", "Virus", "Protozoan", "Yeast"), 1
            ),
            q(
                "Bacteria are classified as:",
                listOf("Eukaryotes", "Prokaryotes", "Protists", "Plants"), 1
            ),
            q(
                "The study of fungi is called:",
                listOf("Virology", "Mycology", "Botany", "Zoology"), 1
            ),
            q(
                "Antibiotics are most effective against:",
                listOf("Viruses", "Bacteria", "Fungi only", "Prions"), 1
            ),
            q(
                "Yeast is used in baking because it produces:",
                listOf("Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen"), 1
            ),
            q(
                "A bacteriophage is a virus that infects:",
                listOf("Humans", "Plants", "Bacteria", "Fungi"), 2
            ),
            q(
                "Which disease is caused by a virus?",
                listOf("Tuberculosis", "Influenza", "Tetanus", "Cholera"), 1
            ),
            q(
                "Many bacteria reproduce through:",
                listOf("Mitosis", "Meiosis", "Binary fission", "Budding only"), 2
            ),
        )
    ),
    BioTest(
        id = "t_evolution",
        title = "Evolution Theory",
        description = "Mechanisms and evidence of descent with modification.",
        iconKey = "tree",
        questions = listOf(
            q(
                "Who proposed the theory of evolution by natural selection?",
                listOf("Mendel", "Darwin", "Pasteur", "Linnaeus"), 1
            ),
            q(
                "A change in allele frequency over generations is called:",
                listOf("Mutation", "Evolution", "Translation", "Fertilization"), 1
            ),
            q(
                "Structures with a common origin but different functions are:",
                listOf("Analogous", "Homologous", "Vestigial", "Convergent"), 1
            ),
            q(
                "Speciation most often requires:",
                listOf(
                    "A single mutation",
                    "Reproductive isolation",
                    "Climate warming",
                    "Predators"
                ), 1
            ),
            q(
                "Fossils are typically found in:",
                listOf("Igneous rock", "Metamorphic rock", "Sedimentary rock", "Basalt only"), 2
            ),
            q(
                "Natural selection acts on:",
                listOf(
                    "Individuals' genes only",
                    "Entire ecosystems",
                    "Heritable variation",
                    "Fossils"
                ), 2
            ),
            q(
                "A vestigial structure is:",
                listOf(
                    "Newly evolved",
                    "Reduced and often non-functional",
                    "Always harmful",
                    "Found only in plants"
                ), 1
            ),
            q(
                "Darwin's famous voyage was aboard the:",
                listOf("HMS Beagle", "HMS Endeavour", "HMS Victory", "HMS Discovery"), 0
            ),
        )
    ),
    BioTest(
        id = "t_ecosystems",
        title = "Ecosystems",
        description = "Energy flow and interactions in nature.",
        iconKey = "globe",
        questions = listOf(
            q(
                "Producers in an ecosystem are usually:",
                listOf("Carnivores", "Herbivores", "Plants", "Decomposers"), 2
            ),
            q(
                "Which is a decomposer?",
                listOf("Eagle", "Fungus", "Deer", "Snake"), 1
            ),
            q(
                "An organism's role in its ecosystem is its:",
                listOf("Habitat", "Niche", "Population", "Biome"), 1
            ),
            q(
                "The energy source for most ecosystems is the:",
                listOf("Sun", "Moon", "Earth's core", "Wind"), 0
            ),
            q(
                "A rainforest is an example of a:",
                listOf("Population", "Community", "Biome", "Species"), 2
            ),
            q(
                "Predator and prey relationships help regulate:",
                listOf("Temperature", "Population size", "Mutation rate", "Gravity"), 1
            ),
            q(
                "Biodiversity refers to:",
                listOf(
                    "Number of individuals",
                    "Variety of life forms",
                    "Size of plants",
                    "Soil quality"
                ), 1
            ),
            q(
                "Which human activity most reduces biodiversity?",
                listOf("Reforestation", "Habitat destruction", "Recycling", "Crop rotation"), 1
            ),
        )
    ),
    BioTest(
        id = "t_food_chains",
        title = "Food Chains",
        description = "How energy flows between living things.",
        iconKey = "chain",
        questions = listOf(
            q(
                "The first level of a food chain is always a(n):",
                listOf("Consumer", "Producer", "Decomposer", "Predator"), 1
            ),
            q(
                "Herbivores are also known as:",
                listOf(
                    "Primary consumers",
                    "Secondary consumers",
                    "Tertiary consumers",
                    "Producers"
                ), 0
            ),
            q(
                "Approximately how much energy is passed to the next trophic level?",
                listOf("1 percent", "10 percent", "50 percent", "90 percent"), 1
            ),
            q(
                "A food web is:",
                listOf(
                    "A single chain",
                    "Many interconnected chains",
                    "A population",
                    "An ecosystem map"
                ), 1
            ),
            q(
                "Decomposers return nutrients to the:",
                listOf("Sun", "Soil", "Predators", "Air only"), 1
            ),
            q(
                "Lions are typically classified as:",
                listOf("Producers", "Primary consumers", "Top predators", "Decomposers"), 2
            ),
            q(
                "Energy pyramids are widest at the:",
                listOf("Top", "Middle", "Bottom", "Sides"), 2
            ),
            q(
                "Which is NOT a consumer?",
                listOf("Hawk", "Mushroom", "Deer", "Grass"), 3
            ),
        )
    ),
    BioTest(
        id = "t_enzymes",
        title = "Enzymes",
        description = "Biological catalysts and their behavior.",
        iconKey = "flask",
        questions = listOf(
            q(
                "Enzymes are primarily made of:",
                listOf("Lipids", "Proteins", "Carbohydrates", "Nucleic acids"), 1
            ),
            q(
                "Enzymes work by:",
                listOf(
                    "Raising activation energy",
                    "Lowering activation energy",
                    "Being consumed",
                    "Changing pH only"
                ), 1
            ),
            q(
                "The specific region where a substrate binds is the:",
                listOf("Active site", "Allosteric site", "Subunit", "Tail"), 0
            ),
            q(
                "Enzyme activity is strongly affected by:",
                listOf("Temperature", "Color", "Shape of container", "Gravity"), 0
            ),
            q(
                "Denaturation of an enzyme means:",
                listOf("It speeds up", "It loses its shape", "It divides", "It duplicates"), 1
            ),
            q(
                "Each enzyme acts on a:",
                listOf("Random substrate", "Specific substrate", "Any molecule", "Only DNA"), 1
            ),
            q(
                "A coenzyme is usually a(n):",
                listOf("Protein", "Organic helper molecule", "Lipid chain", "Carbohydrate"), 1
            ),
            q(
                "Enzymes end many of their names with:",
                listOf("-ose", "-ase", "-in", "-ol"), 1
            ),
        )
    ),
    BioTest(
        id = "t_dna_processes",
        title = "DNA Processes",
        description = "Replication, transcription, and translation.",
        iconKey = "helix",
        questions = listOf(
            q(
                "DNA replication is:",
                listOf("Conservative", "Semi-conservative", "Dispersive only", "Random"), 1
            ),
            q(
                "The enzyme that builds new DNA strands is:",
                listOf("RNA polymerase", "DNA polymerase", "Helicase", "Ligase"), 1
            ),
            q(
                "Transcription produces a molecule of:",
                listOf("DNA", "mRNA", "Protein", "Lipid"), 1
            ),
            q(
                "Translation happens at the:",
                listOf("Nucleus", "Ribosome", "Golgi", "Lysosome"), 1
            ),
            q(
                "Codons are groups of how many nucleotides?",
                listOf("Two", "Three", "Four", "Five"), 1
            ),
            q(
                "tRNA carries:",
                listOf("Lipids", "Amino acids", "Sugars", "Vitamins"), 1
            ),
            q(
                "The stop codon signals the end of:",
                listOf("Replication", "Translation", "Transcription", "Mitosis"), 1
            ),
            q(
                "DNA's base pairs include A with:",
                listOf("C", "G", "T", "U"), 2
            ),
        )
    ),
    BioTest(
        id = "t_immune",
        title = "Immune Defense",
        description = "How the body detects and fights threats.",
        iconKey = "shield",
        questions = listOf(
            q(
                "White blood cells are also called:",
                listOf("Erythrocytes", "Leukocytes", "Thrombocytes", "Myocytes"), 1
            ),
            q(
                "Antibodies are produced by:",
                listOf("T cells", "B cells", "Platelets", "Red blood cells"), 1
            ),
            q(
                "A vaccine works by:",
                listOf(
                    "Killing pathogens on contact",
                    "Teaching the immune system to recognize pathogens",
                    "Replacing damaged cells",
                    "Removing antibodies"
                ), 1
            ),
            q(
                "The first line of immune defense includes:",
                listOf("Antibodies", "Skin and mucous membranes", "Memory cells", "T cells"), 1
            ),
            q(
                "Fever helps fight infection by:",
                listOf(
                    "Freezing bacteria",
                    "Raising body temperature",
                    "Boosting digestion",
                    "Cooling the blood"
                ), 1
            ),
            q(
                "A foreign molecule that triggers an immune response is a(n):",
                listOf("Antigen", "Antibody", "Hormone", "Enzyme"), 0
            ),
            q(
                "Memory cells enable:",
                listOf(
                    "Faster response on re-exposure",
                    "Slower aging",
                    "Allergies only",
                    "Blood clotting"
                ), 0
            ),
            q(
                "Autoimmune diseases occur when the immune system attacks:",
                listOf(
                    "External pathogens",
                    "The body's own tissues",
                    "Red blood cells only",
                    "Bacteria"
                ), 1
            ),
        )
    ),
    BioTest(
        id = "t_reproduction",
        title = "Reproduction Basics",
        description = "How organisms produce offspring.",
        iconKey = "seedling",
        questions = listOf(
            q(
                "Asexual reproduction typically produces offspring that are:",
                listOf(
                    "Identical to the parent",
                    "Very different from the parent",
                    "Hybrid",
                    "Sterile"
                ), 0
            ),
            q(
                "In sexual reproduction, gametes fuse during:",
                listOf("Mitosis", "Fertilization", "Meiosis", "Germination"), 1
            ),
            q(
                "Human sperm and egg each carry how many chromosomes?",
                listOf("46", "23", "12", "48"), 1
            ),
            q(
                "Meiosis produces:",
                listOf(
                    "Two identical cells",
                    "Four genetically varied cells",
                    "One large cell",
                    "Clones"
                ), 1
            ),
            q(
                "Budding is a form of reproduction seen in:",
                listOf("Hydra and yeast", "Humans", "Whales", "Ferns only"), 0
            ),
            q(
                "A zygote is formed from the fusion of a:",
                listOf("Two sperm", "Two eggs", "Sperm and an egg", "Two embryos"), 2
            ),
            q(
                "Flowers are the reproductive structures of:",
                listOf("Mosses", "Ferns", "Angiosperms", "Gymnosperms"), 2
            ),
            q(
                "Pollination is the transfer of pollen to a flower's:",
                listOf("Petal", "Stigma", "Sepal", "Leaf"), 1
            ),
        )
    ),
    BioTest(
        id = "t_hormones",
        title = "Hormones",
        description = "Chemical messengers of the endocrine system.",
        iconKey = "drop",
        questions = listOf(
            q(
                "Insulin is produced by the:",
                listOf("Liver", "Pancreas", "Kidney", "Thyroid"), 1
            ),
            q(
                "The 'master gland' of the endocrine system is the:",
                listOf("Thyroid", "Pituitary", "Adrenal", "Pineal"), 1
            ),
            q(
                "Adrenaline is released mainly during:",
                listOf("Rest", "Stress or fear", "Digestion", "Sleep"), 1
            ),
            q(
                "Thyroxine is produced by the:",
                listOf("Ovary", "Thyroid gland", "Testis", "Adrenal"), 1
            ),
            q(
                "Hormones travel through the:",
                listOf("Nerves", "Bloodstream", "Lymph only", "Digestive tract"), 1
            ),
            q(
                "Growth hormone is released by the:",
                listOf("Adrenal", "Pituitary", "Pancreas", "Liver"), 1
            ),
            q(
                "Estrogen and testosterone are examples of:",
                listOf("Protein hormones", "Steroid hormones", "Neurotransmitters", "Peptides"), 1
            ),
            q(
                "Melatonin helps regulate:",
                listOf("Digestion", "Sleep cycles", "Muscle growth", "Blood sugar"), 1
            ),
        )
    ),
    BioTest(
        id = "t_marine",
        title = "Marine Creatures",
        description = "Life in oceans and other salty waters.",
        iconKey = "wave",
        questions = listOf(
            q(
                "The largest animal on Earth is the:",
                listOf("Elephant", "Blue whale", "Great white shark", "Giant squid"), 1
            ),
            q(
                "Coral reefs are built by tiny animals called:",
                listOf("Polyps", "Krill", "Clams", "Diatoms"), 0
            ),
            q(
                "Dolphins and whales are:",
                listOf("Fish", "Reptiles", "Mammals", "Amphibians"), 2
            ),
            q(
                "Which zone of the ocean receives the most sunlight?",
                listOf("Abyssal", "Bathyal", "Photic", "Aphotic"), 2
            ),
            q(
                "Plankton that produce food via photosynthesis are:",
                listOf("Zooplankton", "Phytoplankton", "Nekton", "Benthos"), 1
            ),
            q(
                "Sharks belong to which class?",
                listOf("Osteichthyes", "Chondrichthyes", "Mammalia", "Reptilia"), 1
            ),
            q(
                "Octopuses and squid are:",
                listOf("Fish", "Mollusks", "Crustaceans", "Reptiles"), 1
            ),
            q(
                "Coral bleaching is often caused by:",
                listOf("Cold water", "Rising temperatures", "Low salinity only", "Sunlight"), 1
            ),
        )
    ),
    BioTest(
        id = "t_biotech",
        title = "Biotechnology Basics",
        description = "Tools and ideas of modern biology.",
        iconKey = "gear",
        questions = listOf(
            q(
                "CRISPR-Cas9 is primarily used to:",
                listOf("Cook food", "Edit genes", "Grow crops only", "Detect viruses only"), 1
            ),
            q(
                "Recombinant DNA technology involves:",
                listOf(
                    "Breaking bones",
                    "Combining DNA from different sources",
                    "Deleting all DNA",
                    "Only copying RNA"
                ), 1
            ),
            q(
                "The first mammal cloned from an adult cell was:",
                listOf("Dolly the sheep", "Snuppy the dog", "Cc the cat", "A cow"), 0
            ),
            q(
                "PCR is used to:",
                listOf("Sequence proteins", "Amplify DNA", "Kill bacteria", "Make ATP"), 1
            ),
            q(
                "A genetically modified organism is abbreviated as:",
                listOf("GOM", "GMO", "GNO", "MGO"), 1
            ),
            q(
                "Gel electrophoresis separates DNA by:",
                listOf("Color", "Size", "Weight only", "Temperature"), 1
            ),
            q(
                "Insulin for diabetes is often produced using:",
                listOf("Plants", "Recombinant bacteria", "Viruses only", "Fungi spores"), 1
            ),
            q(
                "Stem cells are valuable because they can:",
                listOf(
                    "Only make skin",
                    "Differentiate into many cell types",
                    "Die quickly",
                    "Make ATP fast"
                ), 1
            ),
        )
    ),
    BioTest(
        id = "t_animal_class",
        title = "Animal Classification",
        description = "Kingdoms, phyla, and classes at a glance.",
        iconKey = "paw",
        questions = listOf(
            q(
                "Animals with a backbone are called:",
                listOf("Invertebrates", "Vertebrates", "Arthropods", "Mollusks"), 1
            ),
            q(
                "Insects belong to the phylum:",
                listOf("Chordata", "Arthropoda", "Mollusca", "Annelida"), 1
            ),
            q(
                "Which group is cold-blooded?",
                listOf("Mammals", "Birds", "Reptiles", "Marsupials"), 2
            ),
            q(
                "A platypus is a(n):",
                listOf("Reptile", "Bird", "Mammal", "Amphibian"), 2
            ),
            q(
                "Spiders are classified as:",
                listOf("Insects", "Arachnids", "Crustaceans", "Mollusks"), 1
            ),
            q(
                "Birds and reptiles share which trait?",
                listOf("Fur", "Scales/feathers from keratin", "Gills", "Cold blood always"), 1
            ),
            q(
                "Amphibians typically:",
                listOf(
                    "Live only in deserts",
                    "Have a larval aquatic stage",
                    "Lay hard-shelled eggs",
                    "Have fur"
                ), 1
            ),
            q(
                "The scientific name format is:",
                listOf("Family Species", "Genus species", "Class genus", "Phylum class"), 1
            ),
        )
    ),
    BioTest(
        id = "t_human_organs",
        title = "Human Organs",
        description = "Key organs and their essential roles.",
        iconKey = "heart",
        questions = listOf(
            q(
                "The organ that filters blood and produces urine is the:",
                listOf("Liver", "Kidney", "Spleen", "Lung"), 1
            ),
            q(
                "The main organ of the respiratory system is the:",
                listOf("Stomach", "Heart", "Lungs", "Liver"), 2
            ),
            q(
                "Which organ produces bile?",
                listOf("Liver", "Gallbladder", "Pancreas", "Stomach"), 0
            ),
            q(
                "Digestion largely happens in the:",
                listOf("Esophagus", "Small intestine", "Pancreas", "Gallbladder"), 1
            ),
            q(
                "The heart has how many chambers in humans?",
                listOf("Two", "Three", "Four", "Five"), 2
            ),
            q(
                "The largest internal organ is the:",
                listOf("Brain", "Liver", "Lung", "Kidney"), 1
            ),
            q(
                "Oxygen enters the blood in the:",
                listOf("Alveoli", "Bronchi only", "Esophagus", "Trachea"), 0
            ),
            q(
                "The skin's main role includes:",
                listOf("Digestion", "Protection and regulation", "Blood production", "Filtration"),
                1
            ),
        )
    ),
)
