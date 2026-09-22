class Jugador
  attr_accessor :nombre, :puntos, :vidas
  def initialize(nombre)
    @nombre
    @puntos = 0
    @vidas = 3
    @estado = :pequenio
  end
end

class Moneda
  def valor_puntos; 100; end
end

class Hongo
  def poder;crecer; end
end

class Goomba
  def danio_ataque; 1; end
end

class Bowser
  def dano_ataque; 2; end
end

class SistemaDeAudio
  def reproducir(evento)
    sonido = {
      moneda: "'ding.mp3'",
      danio: "'ouch.mp3'",
      game_over: "'game_over.mp3'",
      poder: "'power_up.mp3'",
      pierde_poder: "'pipe_down.mp3'",
      bowser: "'nigggaaaaaaaaaaa.mp3'"
    }
    puts sonido[evento]
  end
end

class SistemaDePoderes
  def consumir_hongo(jugador)
    jugador.estado = :grande
    puts "[PODER] !Mario comio el hongo y ahora es GRANDE!"
  end
end

class SistemaDePuntuacion
  def sumar_puntos(jugador, cantidad)
    jugador.puntos += cantidad
    puts "[+#{cantidad}pts Marcador: #{jugador.puntos}]";
  end
end

class SistemaDeSalud
  def recibir_danio(jugador, cantidad)
    return if cantidad <= 0 

    if jugador.estado == :grande
      jugador.estado = :pequenio
      cantidad -= 1
      puts "[ESTADO] El golpe le quito el poder a Clansy. Vuelve a ser pequeño."
    end

    if cantidad > 0
      jugador.vidas -= cantidad
      jugador.vidas = 0 if jugador.vidas < 0
      puts "Daño recibido: #{cantidad}. Vidas Restantes #{jugador.vidas}"
    end
  end
end

mario = Jugador.new("Clansy")
audio = SistemaDeAudio.new
marcador = SistemaDePuntuacion.new
salud = SistemaDeSalud.new
moneda = Moneda.new
goomba = Goomba.new
poderes = SistemaDePoderes.new
hongo = Hongo.new
bowser = Bowser.new


puts "--- INICIA NIVEL 1-1 ---"
puts "Mario tiene #{mario.vidas} vidas y estado: #{mario.estado}."
puts "---Escenario 1: El hongo y la emboscada---"
poderes.consumir_hongo(mario)
audio.reproducir(:poder)

print "¿Cuantos Goombas emboscan a Mario de golpe?: "
cantidad_goombas = gets.chomp.to_if
cantidad_goombas = 0 if cantidad_goombas < 0

if cantidad_goombas > 0 
  danio_goombas = goomba.danio_ataque * cantidad_goombas
  puts "#{cantidad_goombas} goombas atacan! (Daño total: #{danio_goombas})"
  audio.reproducir(:danio)
  salud.recibir_danio(mario, danio_goombas)
end

puts "---Escenario 2: La llegada de Bowser ---"
if mario.vidas > 0 
  puts "Mario encuentra otro hongo antes del jefe final..."
  poderes.consumir_hongo(mario)
  audio.reproducir(:poder)
  print "¿Cuantas veces logra golpear Bowser a mario?: "
  cantidad_bowser = get.chomp.to_i
  cantidad_bowser = 0 if cantidad_bowser < 0

  if cantidad_bowser > 0
    danio_bowser = bowser.danio_ataque* cantidad_bowser
    puts "Bowser conectas #{cantidad_bowser} golpes! (Daño total): #{danio_bowser}"
    audio.reproducir(:bowser)
    salud.recibir_danio(mario,danio_bowser)
  end
end

puts "--- Resultado final ---"

if mario.vidas <= 0 
  audio.reproducir (:game_over)
  puts "GG. Game over. Mario fue aplastado"
else 
  puts "Mario sobrevivio y rescato a la princesa con #{mario.vidas} vidas."
end




  