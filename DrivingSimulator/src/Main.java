import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring and initializing user input variable
        Scanner keyboard = new Scanner(System.in);

        // User car entrance
        String user_car_entrance = "";

        while ( !(user_car_entrance.equals("e")) ) {
            System.out.println("Press E to enter");
            user_car_entrance = keyboard.nextLine();
            user_car_entrance = user_car_entrance.toLowerCase();
        }

        // NOW YOU ARE INSIDE THE CAR
        if (user_car_entrance.equals("e")) {
            boolean inside_car = true;

            // DECLARING AND INITIALIZING CAR OPERATION VARIABLES
            String user_input_IN_CAR = "";
            String user_input_ENGINE_ON = "";
            String user_input_GEAR = "";
            String user_input_MOVEMENT = "";
            String gear_selection = "P";
            String additional_gear_selection_OPTION = "";
            String engine_status = "OFF";
            String speed_status = "";
            int current_speed = 0;
            int acceleration = 10;
            int brakes = 10;

            while (inside_car) {
                System.out.println("""
                            
                            
                            --------------------   OPTIONS   --------------------
                            Press Z to turn on vehicle
                            Press E to exit the vehicle
                            
                            -----------------   CAR DASHBOARD   -----------------
                            """ +
                            "Engine: " + engine_status + "\n" +
                            "SPEED: " + current_speed + " KM/H\n" +
                            "GEAR: " + gear_selection + "\n");
                user_input_IN_CAR = keyboard.nextLine();
                user_input_IN_CAR = user_input_IN_CAR.toLowerCase();

                switch (user_input_IN_CAR) {
                    // TURNING ON ENGINE
                    case "z":
                        boolean engine_is_ON = true;
                        boolean gear_in_D = false;
                        boolean gear_in_R = false;
                        engine_status = "ON";

                        while (engine_is_ON) {
                            System.out.println("""
                                                                
                                                                
                                    --------------------   OPTIONS   --------------------
                                    Press Z to turn off vehicle
                                    Press B to select gear
                                                                
                                    -----------------   CAR DASHBOARD   -----------------
                                    """ +
                                    "Engine: " + engine_status + "\n" +
                                    "SPEED: " + current_speed + " KM/H\n" +
                                    "GEAR: " + gear_selection + "\n");
                            user_input_ENGINE_ON = keyboard.nextLine();
                            user_input_ENGINE_ON = user_input_ENGINE_ON.toLowerCase();

                            switch (user_input_ENGINE_ON) {
                                // TURNING OFF ENGINE
                                case "z":
                                    engine_is_ON = false;
                                    engine_status = "OFF";
                                    gear_selection = "P";
                                    break;

                                // SELECTING GEAR
                                case "b":
                                    boolean gear_loop = true;
                                    while (gear_loop) {
                                        System.out.println("""
                                                                                            
                                                                                            
                                                ---------------------   GEAR   ---------------------
                                                P
                                                D
                                                R
                                                ----------------------------------------------------
                                                                                            
                                                                                            
                                                """);
                                        user_input_GEAR = keyboard.nextLine();
                                        user_input_GEAR = user_input_GEAR.toLowerCase();

                                        switch (user_input_GEAR) {
                                            // PARKING (P)
                                            case "p":
                                                gear_loop = false;
                                                gear_selection = "P";
                                                break;

                                            // DRIVE (D)
                                            case "d":
                                                gear_loop = false;
                                                gear_in_D = true;
                                                gear_selection = "D";

                                                additional_gear_selection_OPTION = "Press B to select gear";
                                                while (gear_in_D) {
                                                    System.out.println("""
                                                                                                                
                                                             --------------------   OPTIONS   --------------------
                                                            Press W to accelerate
                                                            Press S to brake""");
                                                    System.out.println(additional_gear_selection_OPTION);
                                                    System.out.println("""
                                                                                                                
                                                            -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                                                            "Engine: " + engine_status + "\n" +
                                                            "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                                                            "GEAR: " + gear_selection + "\n");
                                                    user_input_MOVEMENT = keyboard.nextLine();
                                                    user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

                                                    switch (user_input_MOVEMENT) {
                                                        case "w":
                                                            additional_gear_selection_OPTION = "";
                                                            if (current_speed <= 170) {
                                                                current_speed += acceleration;
                                                                speed_status = "";
                                                            } else if (current_speed == 180) {
                                                                speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                                                            }
                                                            break;

                                                        case "s":
                                                            if (current_speed > 0) {
                                                                speed_status = "";
                                                                current_speed -= brakes;
                                                            }
                                                            if (current_speed == 0) {
                                                                additional_gear_selection_OPTION = "Press B to select gear";
                                                            }
                                                            break;

                                                        case "b":
                                                            gear_loop = true;
                                                            while (gear_loop) {
                                                                System.out.println("""
                                                                                                                    
                                                                                                                    
                                                                        ---------------------   GEAR   ---------------------
                                                                        P
                                                                        D
                                                                        R
                                                                        ----------------------------------------------------
                                                                                                                    
                                                                                                                    
                                                                        """);
                                                                user_input_GEAR = keyboard.nextLine();
                                                                user_input_GEAR = user_input_GEAR.toLowerCase();

                                                                switch (user_input_GEAR) {
                                                                    case "p":
                                                                        gear_loop = false;
                                                                        gear_in_D = false;
                                                                        gear_selection = "P";
                                                                        break;

                                                                    case "d":
                                                                        gear_loop = false;
                                                                        gear_selection = "D";
                                                                        break;

                                                                    case "r":
                                                                        gear_loop = false;
                                                                        gear_in_D = false;

                                                                        // THIS AMOUNT OF CODE SHOULD BE SIMPLIFIED BY USING CUSTOM FUNCTIONS
                                                                        gear_in_R = true;
                                                                        gear_selection = "R";

                                                                        additional_gear_selection_OPTION = "Press B to select gear";
                                                                        while (gear_in_R) {
                                                                            System.out.println("""
                                                                                                                                        
                                                                                    --------------------   OPTIONS   --------------------
                                                                                    Press W to accelerate
                                                                                    Press S to brake""");
                                                                            System.out.println(additional_gear_selection_OPTION);
                                                                            System.out.println("""
                                                                                                                                        
                                                                                    -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                                                                                    "Engine: " + engine_status + "\n" +
                                                                                    "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                                                                                    "GEAR: " + gear_selection + "\n");
                                                                            user_input_MOVEMENT = keyboard.nextLine();
                                                                            user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

                                                                            switch (user_input_MOVEMENT) {
                                                                                case "w":
                                                                                    additional_gear_selection_OPTION = "";
                                                                                    if (current_speed <= 30) {
                                                                                        current_speed += acceleration;
                                                                                        speed_status = "";
                                                                                    } else if (current_speed == 40) {
                                                                                        speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                                                                                    }
                                                                                    break;

                                                                                case "s":
                                                                                    if (current_speed > 0) {
                                                                                        speed_status = "";
                                                                                        current_speed -= brakes;
                                                                                    }
                                                                                    if (current_speed == 0) {
                                                                                        additional_gear_selection_OPTION = "Press B to select gear";
                                                                                    }
                                                                                    break;

                                                                                case "b":
                                                                                    System.out.println("""
                                                                                                                                        
                                                                                                                                        
                                                                                            ---------------------   GEAR   ---------------------
                                                                                            P
                                                                                            D
                                                                                            R
                                                                                            ----------------------------------------------------
                                                                                                                                        
                                                                                                                                        
                                                                                            """);
                                                                                    user_input_GEAR = keyboard.nextLine();
                                                                                    user_input_GEAR = user_input_GEAR.toLowerCase();

                                                                                    switch (user_input_GEAR) {
                                                                                        case "p":
                                                                                            gear_in_R = false;
                                                                                            gear_selection = "P";
                                                                                            break;

                                                                                        case "d":
                                                                                            gear_in_R = false;
                                                                                            gear_in_D = true;
                                                                                            gear_selection = "D";
                                                                                            break;

                                                                                        case "r":
                                                                                            gear_selection = "R";
                                                                                            break;
                                                                                    }
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                }
                                                break;

                                            // REVERSE (R)
                                            case "r":
                                                gear_loop = false;
                                                gear_in_R = true;
                                                gear_selection = "R";

                                                additional_gear_selection_OPTION = "Press B to select gear";
                                                while (gear_in_R) {
                                                    System.out.println("""
                                                                                                                
                                                            --------------------   OPTIONS   --------------------
                                                            Press W to accelerate
                                                            Press S to brake""");
                                                    System.out.println(additional_gear_selection_OPTION);
                                                    System.out.println("""
                                                                                                                
                                                            -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                                                            "Engine: " + engine_status + "\n" +
                                                            "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                                                            "GEAR: " + gear_selection + "\n");
                                                    user_input_MOVEMENT = keyboard.nextLine();
                                                    user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

                                                    switch (user_input_MOVEMENT) {
                                                        case "w":
                                                            additional_gear_selection_OPTION = "";
                                                            if (current_speed <= 30) {
                                                                current_speed += acceleration;
                                                                speed_status = "";
                                                            } else if (current_speed == 40) {
                                                                speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                                                            }
                                                            break;

                                                        case "s":
                                                            if (current_speed > 0) {
                                                                speed_status = "";
                                                                current_speed -= brakes;
                                                            }
                                                            if (current_speed == 0) {
                                                                additional_gear_selection_OPTION = "Press B to select gear";
                                                            }
                                                            break;

                                                        case "b":
                                                            gear_loop = true;
                                                            while (gear_loop) {
                                                                System.out.println("""
                                                                                                                    
                                                                                                                    
                                                                        ---------------------   GEAR   ---------------------
                                                                        P
                                                                        D
                                                                        R
                                                                        ----------------------------------------------------
                                                                                                                    
                                                                                                                    
                                                                        """);
                                                                user_input_GEAR = keyboard.nextLine();
                                                                user_input_GEAR = user_input_GEAR.toLowerCase();

                                                                switch (user_input_GEAR) {
                                                                    case "p":
                                                                        gear_loop = false;
                                                                        gear_in_R = false;
                                                                        gear_selection = "P";
                                                                        break;

                                                                    case "d":
                                                                        gear_loop = false;
                                                                        gear_in_R = false;

                                                                        // THIS AMOUNT OF CODE SHOULD BE SIMPLIFIED BY USING CUSTOM FUNCTIONS
                                                                        gear_in_D = true;
                                                                        gear_selection = "D";

                                                                        additional_gear_selection_OPTION = "Press B to select gear";
                                                                        while (gear_in_D) {
                                                                            System.out.println("""
                                                                                                                                        
                                                                                    --------------------   OPTIONS   --------------------
                                                                                    Press W to accelerate
                                                                                    Press S to brake""");
                                                                            System.out.println(additional_gear_selection_OPTION);
                                                                            System.out.println("""
                                                                                                                                        
                                                                                    -----------------   CAR DASHBOARD   -----------------""" + "\n" +
                                                                                    "Engine: " + engine_status + "\n" +
                                                                                    "SPEED: " + current_speed + " KM/H" + speed_status + "\n" +
                                                                                    "GEAR: " + gear_selection + "\n");
                                                                            user_input_MOVEMENT = keyboard.nextLine();
                                                                            user_input_MOVEMENT = user_input_MOVEMENT.toLowerCase();

                                                                            switch (user_input_MOVEMENT) {
                                                                                case "w":
                                                                                    additional_gear_selection_OPTION = "";
                                                                                    if (current_speed <= 170) {
                                                                                        current_speed += acceleration;
                                                                                        speed_status = "";
                                                                                    } else if (current_speed == 180) {
                                                                                        speed_status = "    ⚠ MAXIMUM SPEED ⚠";
                                                                                    }
                                                                                    break;

                                                                                case "s":
                                                                                    if (current_speed > 0) {
                                                                                        speed_status = "";
                                                                                        current_speed -= brakes;
                                                                                    }
                                                                                    if (current_speed == 0) {
                                                                                        additional_gear_selection_OPTION = "Press B to select gear";
                                                                                    }
                                                                                    break;

                                                                                case "b":
                                                                                    gear_loop = true;
                                                                                    while (gear_loop) {
                                                                                        System.out.println("""
                                                                                                                                            
                                                                                                                                            
                                                                                                ---------------------   GEAR   ---------------------
                                                                                                P
                                                                                                D
                                                                                                R
                                                                                                ----------------------------------------------------
                                                                                                                                            
                                                                                                                                            
                                                                                                """);
                                                                                        user_input_GEAR = keyboard.nextLine();
                                                                                        user_input_GEAR = user_input_GEAR.toLowerCase();

                                                                                        switch (user_input_GEAR) {
                                                                                            case "p":
                                                                                                gear_loop = false;
                                                                                                gear_in_D = false;
                                                                                                gear_selection = "P";
                                                                                                break;

                                                                                            case "d":
                                                                                                gear_loop = false;
                                                                                                gear_selection = "D";
                                                                                                break;

                                                                                            case "r":
                                                                                                gear_loop = false;
                                                                                                gear_in_D = false;
                                                                                                gear_in_R = true;
                                                                                                gear_selection = "R";
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;

                                                                    case "r":
                                                                        gear_loop = false;
                                                                        gear_selection = "R";
                                                                        break;
                                                                }
                                                            }
                                                            break;


                                                    }
                                                }
                                                break;
                                            // NOT USING DEFAULT ON PURPOSE SO THAT NOTHING JUST HAPPENS
                                        }
                                    }
                                    break;
                            }
                        }
                        break;

                    // EXITING CAR
                    case "e":
                        inside_car = false;
                        break;

                    // NOT USING DEFAULT ON PURPOSE SO THAT NOTHING JUST HAPPENS

                }
            }
        }







            }
        }