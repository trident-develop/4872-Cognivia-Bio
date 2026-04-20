package com.takeonecompany.bp.data

import com.takeonecompany.bp.model.LearnCategory
import com.takeonecompany.bp.model.Topic

private fun topic(
    title: String,
    summary: String,
    keyPoints: List<String>,
    deepDive: String,
) = Topic(
    id = title.lowercase().replace(" ", "_"),
    title = title,
    summary = summary,
    keyPoints = keyPoints,
    deepDive = deepDive,
)

val MockCategories: List<LearnCategory> = listOf(
    LearnCategory(
        id = "cell_biology",
        title = "Cell Biology",
        subtitle = "The fundamental units of every living organism",
        iconKey = "cell",
        topics = listOf(
            topic(
                "Cell Structure",
                "Basic architecture shared by every living cell.",
                listOf(
                    "Every cell is enclosed by a selectively permeable plasma membrane.",
                    "Eukaryotic cells contain membrane-bound organelles; prokaryotic cells do not.",
                    "The cytoplasm holds organelles suspended in a watery, protein-rich cytosol.",
                ),
                "Cells range in size from tiny bacteria a few micrometers across to an ostrich egg yolk visible without a microscope. Despite their variety, they share a common blueprint: a boundary, genetic material, and the molecular machinery to turn nutrients into useful work."
            ),
            topic(
                "Organelles",
                "Specialized compartments and their roles.",
                listOf(
                    "Mitochondria generate ATP through cellular respiration.",
                    "The endoplasmic reticulum and Golgi apparatus build and ship proteins.",
                    "Lysosomes recycle worn-out components using digestive enzymes.",
                ),
                "Each organelle is like a workshop tuned for one type of task. Because the workshops are separated by membranes, a cell can run many chemistries in parallel without conflicts — for example, building proteins in the ER while breaking down waste inside a lysosome."
            ),
            topic(
                "Cell Membrane",
                "Selective barrier and transport mechanisms.",
                listOf(
                    "Phospholipid bilayers spontaneously form because of hydrophobic tails and polar heads.",
                    "Proteins embedded in the membrane act as channels, pumps, and receptors.",
                    "Transport can be passive (diffusion) or active (using ATP).",
                ),
                "The membrane is less a wall than a busy checkpoint. It decides what enters, what leaves, and how fast — keeping essential ions high on the inside, waste moving out, and signals crossing at just the right moments."
            ),
            topic(
                "Cell Division",
                "Mitosis, meiosis, and the cell cycle.",
                listOf(
                    "Mitosis produces two identical daughter cells for growth and repair.",
                    "Meiosis produces four genetically varied gametes.",
                    "Checkpoints in the cell cycle guard against replication errors.",
                ),
                "Cell division has to be strict about timing and fidelity: a single mistake can lead to tumors or developmental defects. The cell cycle checkpoints behave like quality gates that halt division until each step is verified."
            ),
        )
    ),
    LearnCategory(
        id = "genetics",
        title = "Genetics",
        subtitle = "How traits pass from one generation to the next",
        iconKey = "dna",
        topics = listOf(
            topic(
                "DNA and RNA",
                "Structure of nucleic acids and their roles.",
                listOf(
                    "DNA is a double helix made of A-T and G-C base pairs.",
                    "RNA is single-stranded and uses uracil instead of thymine.",
                    "Both store or transmit information using a four-letter alphabet.",
                ),
                "DNA is the long-term archive of life's instructions; RNA is the working copy. Together they make the central dogma possible: DNA is read into RNA, which is translated into proteins — the molecules that do the actual work."
            ),
            topic(
                "Genes and Chromosomes",
                "Genetic units and packaging in cells.",
                listOf(
                    "A gene is a segment of DNA that codes for a product (often a protein).",
                    "Chromosomes package long DNA strands around histone proteins.",
                    "Humans have 23 pairs of chromosomes, including one pair of sex chromosomes.",
                ),
                "Chromosomes are brilliant storage devices. Meters of DNA are folded, twisted, and coiled so tightly they fit inside a microscopic nucleus, yet can still be unspooled precisely where the cell needs to read a specific gene."
            ),
            topic(
                "Heredity",
                "Mendelian rules and inheritance patterns.",
                listOf(
                    "Each parent contributes one allele per gene to the offspring.",
                    "Dominant alleles mask recessive ones in heterozygous combinations.",
                    "Traits can also be influenced by multiple genes and by the environment.",
                ),
                "Mendel's pea plant experiments revealed that inheritance follows discrete rules, not a simple blending. Modern genetics has layered on complexity — linkage, epistasis, epigenetics — but those core ratios still hold for many traits."
            ),
            topic(
                "Mutations",
                "Sources and effects of genetic change.",
                listOf(
                    "Point mutations change a single base; indels add or remove bases.",
                    "Mutations can be silent, harmful, or occasionally beneficial.",
                    "Repair systems fix most errors before they become permanent.",
                ),
                "Without mutations there would be no evolution, but too many are catastrophic. Cells balance these pressures with a finely tuned mix of proofreading enzymes and repair pathways that tolerate variation while preventing chaos."
            ),
        )
    ),
    LearnCategory(
        id = "human_anatomy",
        title = "Human Anatomy",
        subtitle = "Structure of the human body and its systems",
        iconKey = "anatomy",
        topics = listOf(
            topic(
                "Skeletal System",
                "Bones, joints, and structural support.",
                listOf(
                    "The adult skeleton has roughly 206 bones.",
                    "Bones store minerals and produce blood cells in the marrow.",
                    "Joints allow movement while ligaments keep bones aligned.",
                ),
                "Your skeleton is a living framework that continuously remodels itself, laying down new bone where stress is highest and reabsorbing it where it isn't needed. Strong bones are a conversation between movement, nutrition, and hormones."
            ),
            topic(
                "Muscular System",
                "Skeletal, smooth, and cardiac muscle.",
                listOf(
                    "Skeletal muscle is voluntary and attached to bones by tendons.",
                    "Smooth muscle moves substances through hollow organs.",
                    "Cardiac muscle contracts rhythmically and never tires.",
                ),
                "Muscles convert chemical energy into motion by sliding protein filaments across each other. Every step, heartbeat, and digestive contraction ultimately comes from the same elegant mechanism, scaled differently across tissues."
            ),
            topic(
                "Nervous System",
                "Brain, spinal cord, and neural pathways.",
                listOf(
                    "The central nervous system integrates and commands.",
                    "The peripheral nervous system carries signals to and from the body.",
                    "Neurons communicate using electrical impulses and chemical messengers.",
                ),
                "Your nervous system is a living internet. Billions of neurons continuously exchange messages, forming networks that let you think, feel, remember, and adjust to a world that never sits still."
            ),
            topic(
                "Digestive System",
                "Path of food and nutrient absorption.",
                listOf(
                    "Digestion begins in the mouth with mechanical and chemical breakdown.",
                    "The small intestine absorbs most nutrients into the bloodstream.",
                    "Beneficial microbes in the large intestine aid fermentation and vitamin production.",
                ),
                "Food travels about nine meters through the digestive tract, losing its structure so the body can repurpose its atoms. Every sandwich is literally rebuilt into you."
            ),
        )
    ),
    LearnCategory(
        id = "physiology",
        title = "Physiology",
        subtitle = "How living systems function and stay balanced",
        iconKey = "heart",
        topics = listOf(
            topic(
                "Homeostasis",
                "Regulating stable internal conditions.",
                listOf(
                    "Feedback loops detect deviations and trigger correction.",
                    "Core temperature, blood pH, and glucose are tightly controlled.",
                    "Failure of homeostasis is at the root of many diseases.",
                ),
                "Homeostasis is the body's thermostat for everything. Sensors, integrators, and effectors work together to nudge values back toward a set point, even while the outside world swings wildly."
            ),
            topic(
                "Respiration",
                "Gas exchange from lungs to cells.",
                listOf(
                    "Oxygen moves from alveoli to blood, then to cells; CO2 goes the other way.",
                    "Hemoglobin in red blood cells transports most of the oxygen.",
                    "Breathing rate adjusts to metabolic demand automatically.",
                ),
                "Each breath is the culmination of diffusion, transport, and cellular chemistry, all choreographed to keep every cell supplied with the oxygen it needs for energy."
            ),
            topic(
                "Circulation",
                "Heart, blood vessels, and blood flow.",
                listOf(
                    "The heart has four chambers that separate oxygenated and deoxygenated blood.",
                    "Arteries carry blood away from the heart; veins carry it back.",
                    "Capillaries are where exchange with tissues happens.",
                ),
                "Your heart beats roughly 100,000 times a day, pushing about five liters of blood through a network long enough to wrap around the Earth twice. It is the ultimate delivery system."
            ),
            topic(
                "Hormones",
                "Endocrine signals that shape the body.",
                listOf(
                    "Hormones travel through the bloodstream to distant targets.",
                    "They regulate metabolism, growth, reproduction, and mood.",
                    "Small amounts can produce large effects via receptor binding.",
                ),
                "Hormones are whispers that move entire systems. A tiny change in hormone levels can shift mood, hunger, energy, or growth — which is why the endocrine system is so tightly regulated."
            ),
        )
    ),
    LearnCategory(
        id = "botany",
        title = "Botany",
        subtitle = "The green world of plants and algae",
        iconKey = "leaf",
        topics = listOf(
            topic(
                "Plant Cells",
                "Walls, chloroplasts, and vacuoles.",
                listOf(
                    "A rigid cellulose cell wall provides structural support.",
                    "Chloroplasts contain the green pigment chlorophyll for photosynthesis.",
                    "A large central vacuole manages water pressure and storage.",
                ),
                "Plant cells are self-sufficient solar factories. The cell wall gives a tree its strength, the chloroplasts make its food, and the vacuole helps keep every leaf turgid and upright."
            ),
            topic(
                "Photosynthesis",
                "Turning light into chemical energy.",
                listOf(
                    "Light reactions in thylakoids capture photons and produce ATP and NADPH.",
                    "The Calvin cycle in the stroma builds sugars from CO2.",
                    "Oxygen is a byproduct of splitting water.",
                ),
                "Photosynthesis is the original renewable energy: sunlight becomes sugar, and nearly every food chain on Earth can be traced back to it."
            ),
            topic(
                "Plant Reproduction",
                "Flowers, pollination, and seeds.",
                listOf(
                    "Many plants rely on wind, water, or animals to move pollen.",
                    "Fertilization produces a seed containing an embryo and nutrients.",
                    "Fruits help disperse seeds away from the parent plant.",
                ),
                "A flower is a carefully designed invitation. Its colors, shapes, and scents are tuned for specific pollinators, whether bees, birds, or beetles."
            ),
            topic(
                "Roots and Leaves",
                "Absorption, support, and exchange.",
                listOf(
                    "Roots anchor the plant and absorb water and minerals.",
                    "Leaves have tiny stomata that regulate gas exchange.",
                    "Vascular tissues move water up and sugars throughout the plant.",
                ),
                "Roots quietly explore the soil in search of water, while leaves track the sun. Together they form a two-sided engine powering the entire plant."
            ),
        )
    ),
    LearnCategory(
        id = "zoology",
        title = "Zoology",
        subtitle = "The diverse kingdom of animal life",
        iconKey = "paw",
        topics = listOf(
            topic(
                "Invertebrates",
                "Animals without a backbone.",
                listOf(
                    "Invertebrates make up over 95% of all animal species.",
                    "They include insects, mollusks, crustaceans, and worms.",
                    "Many have exoskeletons or hydrostatic skeletons instead of bones.",
                ),
                "From microscopic rotifers to giant squid, invertebrates dominate in numbers and diversity. Many ecosystems would collapse without them."
            ),
            topic(
                "Vertebrates",
                "Fish, amphibians, reptiles, birds, mammals.",
                listOf(
                    "All vertebrates share an internal backbone and spinal cord.",
                    "Fish were the first vertebrates, over 500 million years ago.",
                    "Mammals are warm-blooded and mostly give birth to live young.",
                ),
                "Vertebrates evolved a clever trick: an internal skeleton that grows with the animal. This allowed bodies to get larger, faster, and smarter than most invertebrate designs."
            ),
            topic(
                "Animal Behavior",
                "Instinct, learning, and social life.",
                listOf(
                    "Innate behaviors are genetically programmed reflexes.",
                    "Learned behaviors come from experience and feedback.",
                    "Many species form complex social structures.",
                ),
                "Behavior is biology in motion. It reveals how evolution, nervous systems, and environment collide to shape everything an animal does."
            ),
            topic(
                "Adaptation",
                "How species fit their environments.",
                listOf(
                    "Structural adaptations change body shape or parts.",
                    "Behavioral adaptations alter what the animal does.",
                    "Physiological adaptations tune internal chemistry.",
                ),
                "An animal's body is a catalog of environmental pressures. Every feature, from the arctic fox's coat to the camel's hump, is a compromise refined by generations."
            ),
        )
    ),
    LearnCategory(
        id = "microbiology",
        title = "Microbiology",
        subtitle = "Life too small to see with the naked eye",
        iconKey = "microbe",
        topics = listOf(
            topic(
                "Bacteria",
                "Single-celled prokaryotes and their roles.",
                listOf(
                    "Bacteria lack a nucleus but have circular DNA.",
                    "They reproduce quickly, often by binary fission.",
                    "Most bacteria are harmless or beneficial; a minority cause disease.",
                ),
                "Bacteria were the first life forms to shape Earth's atmosphere, and they still run essential processes today — from nitrogen fixation in soil to fermentation in yogurt."
            ),
            topic(
                "Viruses",
                "Non-living particles that hijack cells.",
                listOf(
                    "Viruses consist of genetic material wrapped in a protein shell.",
                    "They need a host cell to replicate.",
                    "Antibiotics do not work against viruses.",
                ),
                "Viruses blur the line between chemistry and biology. They can't move or eat, but once inside a cell they turn it into a factory for more viruses."
            ),
            topic(
                "Fungi",
                "Molds, yeasts, and mushrooms.",
                listOf(
                    "Fungi have cell walls made of chitin.",
                    "Most are decomposers, recycling dead organic matter.",
                    "Some form partnerships with plant roots, helping absorb nutrients.",
                ),
                "Fungi are more closely related to animals than to plants. Without them, forests would drown in dead leaves and fallen trees."
            ),
            topic(
                "Protozoa",
                "Single-celled eukaryotes of many shapes.",
                listOf(
                    "Protozoa include amoebas, ciliates, and flagellates.",
                    "Most live in water or moist environments.",
                    "A few can cause human diseases such as malaria.",
                ),
                "Protozoa are microscopic hunters. Despite being single cells, many move, feed, and react like tiny animals."
            ),
        )
    ),
    LearnCategory(
        id = "evolution",
        title = "Evolution",
        subtitle = "How species change across deep time",
        iconKey = "tree",
        topics = listOf(
            topic(
                "Natural Selection",
                "Differential survival and reproduction.",
                listOf(
                    "Variation exists within every population.",
                    "Some variants leave more offspring than others.",
                    "Over generations, those heritable traits become more common.",
                ),
                "Natural selection is not a force that pushes species toward a goal. It is a quiet bookkeeping of what works: useful traits get copied more, and less useful ones fade."
            ),
            topic(
                "Adaptation",
                "Traits that raise fitness in an environment.",
                listOf(
                    "Adaptations can be anatomical, behavioral, or biochemical.",
                    "They are only useful in the environment that shaped them.",
                    "What was once adaptive can become obsolete if conditions change.",
                ),
                "An adaptation is an answer to a question the environment keeps asking. When the question changes, the answer eventually must change too."
            ),
            topic(
                "Speciation",
                "How one species becomes two.",
                listOf(
                    "Isolation lets populations accumulate different changes.",
                    "Geographic barriers are a common trigger.",
                    "After enough change, interbreeding becomes impossible.",
                ),
                "Speciation is gradual. There is no magic moment when a new species appears; it is only in hindsight that the split becomes obvious."
            ),
            topic(
                "Fossil Evidence",
                "What ancient remains reveal.",
                listOf(
                    "Fossils form mainly in sedimentary rock.",
                    "Relative and radiometric dating establish their age.",
                    "Transitional fossils show gradual change between groups.",
                ),
                "Fossils are snapshots from life's deep history. They confirm what genetics, anatomy, and biogeography already imply — that today's species are branches on a very old tree."
            ),
        )
    ),
    LearnCategory(
        id = "ecology",
        title = "Ecology",
        subtitle = "The web of life and its environment",
        iconKey = "globe",
        topics = listOf(
            topic(
                "Ecosystems",
                "Biotic and abiotic interactions.",
                listOf(
                    "An ecosystem links living organisms with their physical surroundings.",
                    "Energy flows while matter cycles.",
                    "Small changes in one part can ripple across the whole system.",
                ),
                "Ecosystems function like orchestras. Every species plays a small part, but remove a section and the whole song changes."
            ),
            topic(
                "Food Chains",
                "Energy flow between organisms.",
                listOf(
                    "Producers convert sunlight into food.",
                    "Consumers eat producers or other consumers.",
                    "Decomposers recycle nutrients back into the system.",
                ),
                "A food chain is a trail of calories. Each step loses most of the energy as heat, which is why top predators are always rare."
            ),
            topic(
                "Biomes",
                "Forests, deserts, tundras, and more.",
                listOf(
                    "Biomes are shaped mostly by climate and geography.",
                    "Each supports characteristic plant and animal communities.",
                    "Small local ecosystems exist within every biome.",
                ),
                "Biomes are large-scale patterns of life. Travel from equator to pole and you can read the story of climate in the plants and animals around you."
            ),
            topic(
                "Environmental Balance",
                "Sustainability and human impact.",
                listOf(
                    "Habitat loss is the largest driver of biodiversity decline.",
                    "Pollution and climate change add further pressure.",
                    "Conservation restores balance through protected areas and careful use.",
                ),
                "The biosphere is resilient but not limitless. Keeping it healthy is both an ethical choice and a practical necessity for our own survival."
            ),
        )
    ),
    LearnCategory(
        id = "biochemistry",
        title = "Biochemistry",
        subtitle = "The molecules that drive life",
        iconKey = "flask",
        topics = listOf(
            topic(
                "Proteins",
                "Chains of amino acids that do the work.",
                listOf(
                    "Proteins are built from 20 different amino acids.",
                    "Their 3D shape determines their function.",
                    "They act as enzymes, transporters, signals, and structural material.",
                ),
                "Proteins are the hands of the cell. Almost every process you can name has a specific protein, folded just so, quietly carrying it out."
            ),
            topic(
                "Lipids",
                "Fats, oils, and membranes.",
                listOf(
                    "Lipids store energy densely.",
                    "Phospholipids form the core of cell membranes.",
                    "Steroid lipids include many hormones.",
                ),
                "Lipids are chemically diverse and surprisingly versatile. They insulate, store, communicate, and form the very boundaries of life."
            ),
            topic(
                "Carbohydrates",
                "Sugars and storage molecules.",
                listOf(
                    "Simple sugars like glucose power cellular reactions.",
                    "Complex carbohydrates are long chains for storage or structure.",
                    "Plants store energy as starch; animals store it as glycogen.",
                ),
                "Carbohydrates are the currency of short-term energy. Plants also use them as structural materials — cellulose is the most abundant organic molecule on Earth."
            ),
            topic(
                "Enzymes",
                "Biological catalysts with precise shapes.",
                listOf(
                    "Enzymes lower the energy needed to start a reaction.",
                    "They bind specific substrates at an active site.",
                    "Temperature and pH changes can denature them.",
                ),
                "Enzymes let biology happen at body temperature and reasonable speeds. Without them, many essential reactions would be too slow to matter."
            ),
        )
    ),
    LearnCategory(
        id = "immunology",
        title = "Immunology",
        subtitle = "The body's defense against disease",
        iconKey = "shield",
        topics = listOf(
            topic(
                "Immune System",
                "Innate and adaptive defenses.",
                listOf(
                    "Innate immunity responds quickly and broadly.",
                    "Adaptive immunity is slower but specific and has memory.",
                    "Both rely on a large cast of specialized white blood cells.",
                ),
                "Your immune system is a distributed security force. It identifies threats, remembers them, and coordinates responses across the whole body."
            ),
            topic(
                "Antibodies",
                "Proteins that recognize invaders.",
                listOf(
                    "Antibodies are Y-shaped proteins that bind specific antigens.",
                    "They mark pathogens for destruction or neutralize them.",
                    "Each B cell makes a unique antibody shape.",
                ),
                "Antibodies are like molecular name tags. Once a pathogen is tagged, other parts of the immune system know exactly what to remove."
            ),
            topic(
                "Vaccines",
                "Training the immune system safely.",
                listOf(
                    "Vaccines expose the body to harmless versions of pathogens.",
                    "This triggers memory cells without causing disease.",
                    "Herd immunity protects those who can't be vaccinated.",
                ),
                "Vaccination is one of medicine's most powerful tools. It lets the immune system rehearse before the real threat arrives."
            ),
            topic(
                "Infections",
                "How pathogens cause disease.",
                listOf(
                    "Infection begins when a pathogen enters and multiplies.",
                    "Symptoms can come from the pathogen or the immune response itself.",
                    "Some infections are acute; others become chronic.",
                ),
                "Infection is a race between pathogen growth and immune response. When the body wins quickly, you barely notice. When it doesn't, disease follows."
            ),
        )
    ),
    LearnCategory(
        id = "reproduction",
        title = "Reproduction",
        subtitle = "How life makes more life",
        iconKey = "seedling",
        topics = listOf(
            topic(
                "Asexual Reproduction",
                "One parent, identical offspring.",
                listOf(
                    "No fusion of gametes is required.",
                    "Offspring are genetic copies of the parent.",
                    "It is fast and efficient in stable environments.",
                ),
                "Asexual reproduction is a copy-paste strategy. It works beautifully when conditions are stable, but struggles when the environment changes."
            ),
            topic(
                "Sexual Reproduction",
                "Mixing genes across two parents.",
                listOf(
                    "Two gametes combine to form a unique zygote.",
                    "Meiosis shuffles alleles before they are passed on.",
                    "This variation is raw material for evolution.",
                ),
                "Sexual reproduction trades speed for flexibility. By mixing genes each generation, it produces variety — and variety is the currency of adaptation."
            ),
            topic(
                "Human Reproduction",
                "Anatomy and fertilization.",
                listOf(
                    "Sperm is produced in the testes; eggs mature in the ovaries.",
                    "Fertilization typically occurs in a fallopian tube.",
                    "Hormones coordinate the whole cycle.",
                ),
                "Human reproduction depends on exquisite timing. Hormones orchestrate ovulation, fertilization, and implantation across weeks and months."
            ),
            topic(
                "Development",
                "From zygote to full organism.",
                listOf(
                    "The zygote divides rapidly into an embryo.",
                    "Cells differentiate into tissues and organs.",
                    "Development continues long after birth.",
                ),
                "Development is choreography at the cellular scale. A single fertilized cell follows molecular cues to become trillions of coordinated, specialized cells."
            ),
        )
    ),
    LearnCategory(
        id = "molecular_biology",
        title = "Molecular Biology",
        subtitle = "The inner workings of DNA and proteins",
        iconKey = "helix",
        topics = listOf(
            topic(
                "DNA Replication",
                "How cells copy their genome.",
                listOf(
                    "Replication is semi-conservative: each new helix has one old strand.",
                    "DNA polymerase builds new strands using the old ones as templates.",
                    "Proofreading minimizes errors.",
                ),
                "Every time a cell divides, it must copy billions of base pairs almost perfectly. Replication is one of the most accurate processes in all of chemistry."
            ),
            topic(
                "Transcription",
                "Making RNA from DNA.",
                listOf(
                    "RNA polymerase reads a DNA strand and builds messenger RNA.",
                    "Only relevant gene regions are transcribed at a given time.",
                    "Regulation of transcription controls cell identity.",
                ),
                "Transcription is the cell's way of reading without losing the book. The original DNA stays safely in the nucleus while copies carry the information to where it's needed."
            ),
            topic(
                "Translation",
                "Building proteins from mRNA.",
                listOf(
                    "Ribosomes read mRNA three letters at a time.",
                    "tRNA delivers the matching amino acid for each codon.",
                    "The result is a specific chain that folds into a functional protein.",
                ),
                "Translation is the moment genetic information becomes physical action. A sequence of letters turns into a three-dimensional machine."
            ),
            topic(
                "Gene Expression",
                "When and where genes switch on.",
                listOf(
                    "Most cells carry the whole genome but only use part of it.",
                    "Transcription factors switch genes on or off.",
                    "Epigenetic marks can influence expression without changing DNA.",
                ),
                "Gene expression explains how identical cells become different tissues. It's the cell's way of choosing which pages of the same book to read."
            ),
        )
    ),
    LearnCategory(
        id = "biotechnology",
        title = "Biotechnology",
        subtitle = "Engineering biology for human benefit",
        iconKey = "gear",
        topics = listOf(
            topic(
                "Genetic Engineering",
                "Inserting and editing genes.",
                listOf(
                    "Recombinant DNA combines genes from different sources.",
                    "Bacteria and yeast are common production hosts.",
                    "Modern tools allow precise edits at chosen locations.",
                ),
                "Genetic engineering turned cells into programmable factories. Today, bacteria can produce human insulin, vaccines, and countless research tools."
            ),
            topic(
                "Cloning",
                "Creating genetic copies of cells or organisms.",
                listOf(
                    "Molecular cloning copies specific DNA sequences.",
                    "Reproductive cloning copies whole organisms.",
                    "Therapeutic cloning aims to produce matching tissues for medicine.",
                ),
                "Cloning raises real biological and ethical questions. It shows what is technically possible while forcing us to consider what is desirable."
            ),
            topic(
                "CRISPR Basics",
                "Precise gene editing tools.",
                listOf(
                    "CRISPR was adapted from a bacterial immune defense.",
                    "A guide RNA steers the Cas enzyme to a specific DNA site.",
                    "The cell's repair machinery completes the edit.",
                ),
                "CRISPR made gene editing cheap and specific. It is rewriting research timelines and opening new therapies for diseases that had no treatment before."
            ),
            topic(
                "Medical Biotechnology",
                "Therapies, diagnostics, and more.",
                listOf(
                    "Biologic drugs include antibodies, insulin, and vaccines.",
                    "Gene therapies correct or replace faulty genes.",
                    "Molecular tests diagnose disease from small samples.",
                ),
                "Medical biotechnology has shifted medicine from broad strokes to molecular precision. Treatments now increasingly target the exact cause of disease."
            ),
        )
    ),
    LearnCategory(
        id = "marine_biology",
        title = "Marine Biology",
        subtitle = "Life beneath the surface of the sea",
        iconKey = "wave",
        topics = listOf(
            topic(
                "Ocean Ecosystems",
                "Zones, currents, and nutrients.",
                listOf(
                    "Oceans are divided into light-filled upper zones and dark deep zones.",
                    "Currents move heat, nutrients, and organisms across the planet.",
                    "Upwelling brings deep nutrients to the surface, fueling life.",
                ),
                "Oceans are not uniform; they are layered and constantly moving. Understanding their structure is key to understanding global climate and life."
            ),
            topic(
                "Marine Species",
                "From plankton to whales.",
                listOf(
                    "Plankton are the foundation of most ocean food webs.",
                    "Fish dominate in numbers and diversity of vertebrates.",
                    "Marine mammals are air-breathers adapted to the sea.",
                ),
                "Ocean life spans an astonishing range of sizes and strategies. The tiniest plankton ultimately feed the largest animals that have ever lived."
            ),
            topic(
                "Coral Reefs",
                "Biodiversity hotspots of the ocean.",
                listOf(
                    "Reefs are built by tiny coral polyps with algal partners.",
                    "They support a quarter of all marine species.",
                    "Warming and acidification threaten them worldwide.",
                ),
                "Coral reefs are the rainforests of the sea. Their beauty is fragile, built on a partnership between animals and algae that warms water can undo."
            ),
            topic(
                "Adaptations in Water",
                "Living under pressure and salt.",
                listOf(
                    "Streamlined bodies reduce drag while swimming.",
                    "Special kidneys and glands manage salt balance.",
                    "Deep-sea animals cope with cold, darkness, and crushing pressure.",
                ),
                "Water is a tough neighborhood. Marine organisms have evolved a remarkable toolkit — from bioluminescence to antifreeze proteins — to thrive there."
            ),
        )
    ),
)
