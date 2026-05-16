import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== MEWTWO SECURITY SYSTEM ===");

        WantPlayAgain();

        closeScanner();
    }

    public static void FirstMessage() {

        String message = """
            Bem-vindo(a) à Caverna de Cerulean City!
            Para me desafiar, você deve responder a uma série de perguntas sobre si próprio a fim de provar que é digno(a) de enfrentar o poderoso Mewtwo.
            Serão respostas de sim ou não, e cada resposta correta te levará um passo mais perto de enfrentar-me.
            Boa sorte, você vai precisar!
            """;

        System.out.println(message);
    }

    public static Trainer AboutTrainer() {

        Trainer trainer = new Trainer();

        do {

            System.out.println("Primeiramente, qual é o seu nome?");
            trainer.name = scanner.nextLine().trim();

            if (trainer.name.isEmpty()) {

                System.out.println(
                    "O nome não pode ser vazio."
                );

            } else if (trainer.name.matches(".*\\d.*")) {

                System.out.println(
                    "Números não são permitidos no nome."
                );
            }

        } while (
            trainer.name.isEmpty() ||
            trainer.name.matches(".*\\d.*")
        );

        do {

            System.out.println("De qual cidade você é?");
            trainer.city = scanner.nextLine().trim();

            if (trainer.city.isEmpty()) {

                System.out.println(
                    "A cidade não pode ser vazia."
                );

            } else if (trainer.city.matches(".*\\d.*")) {

                System.out.println(
                    "Números não são permitidos no nome da cidade."
                );
            }

        } while (
            trainer.city.isEmpty() ||
            trainer.city.matches(".*\\d.*")
        );

        java.util.List<String> kantoCities = java.util.List.of(

            "Pallet",
            "Cidade de Pallet",

            "Viridian",
            "Cidade de Viridian",

            "Pewter",
            "Cidade de Pewter",

            "Cerulean",
            "Cidade de Cerulean",

            "Vermilion",
            "Cidade de Vermilion",

            "Lavender",
            "Cidade de Lavender",

            "Celadon",
            "Cidade de Celadon",

            "Fuchsia",
            "Cidade de Fuchsia",

            "Saffron",
            "Cidade de Saffron"
        );

        if (kantoCities.contains(trainer.city)) {

            System.out.println(
                "Ah, você é de " + trainer.city +
                "! Vamos ver se você irá honrar sua cidade enfrentando-me!"
            );

        } else {

            System.out.println(
                "Interessante, " + trainer.city +
                " não é uma cidade de Kanto. Viajou bastante para chegar aqui, hein?"
            );
        }

        return trainer;
    }

    public static Trainer TrainerExperience(Trainer trainer) {

        System.out.println(
            "Para as perguntas a seguir, responda 1 para SIM e 0 para NÃO."
        );

        trainer.score = 0;

        trainer.score += AskQuestion(
            "Você foi o vencedor da Liga Pokémon?",
            "Sério? Nem venceu uma Liga Pokémon?"
        );

        trainer.score += AskQuestion(
            "Você capturou ou derrotou um Pokémon lendário?",
            "Nem sequer um lendário?"
        );

        trainer.score += AskQuestion(
            "Você derrotou a Equipe Rocket?",
            "Você precisa derrotar uma organização criminosa."
        );

        trainer.score += AskQuestion(
            "Seus 6 Pokémons estão acima do nível 73?",
            "Volte quando seus Pokémons estiverem mais fortes."
        );

        trainer.score += AskQuestion(
            "Você possui amizade máxima com seu Pokémon principal?",
            "Um verdadeiro treinador precisa criar vínculos."
        ) * 2;

        System.out.printf(
            "%s de %s, sua pontuação final é: %d pontos.%n",
            trainer.name,
            trainer.city,
            trainer.score
        );

        if (trainer.score >= 4) {

            System.out.println(
                "Parabéns! Você é digno(a) de enfrentar-me!"
            );

        } else {

            System.out.println(
                "Volte quando cumprir os requisitos mínimos (4 pontos)."
            );
        }

        return trainer;
    }

    public static int AskQuestion(
        String question,
        String failMessage
    ) {

        int answer;

        do {

            System.out.println(question);

            answer = scanner.nextInt();

            if (answer == 1) {

                return 1;

            } else if (answer == 0) {

                System.out.println(failMessage);

                return 0;

            } else {

                System.out.println(
                    "Resposta inválida. Responda 1 para SIM ou 0 para NÃO."
                );
            }

        } while (true);
    }

    public static int WantPlayAgain() {

        int playAgain = 1;

        while (playAgain == 1) {

            FirstMessage();

            Trainer trainer = AboutTrainer();

            TrainerExperience(trainer);

            do {

                System.out.println("""

                    Deseja tentar novamente?

                    1 - Sim
                    0 - Não
                    """);

                playAgain = scanner.nextInt();

                scanner.nextLine();

                if (playAgain != 1 && playAgain != 0) {

                    System.out.println(
                        "Resposta inválida."
                    );
                }

            } while (playAgain != 1 && playAgain != 0);
        }

        return playAgain;
    }

    public static void closeScanner() {

        scanner.close();
    }
}