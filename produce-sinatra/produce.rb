require 'sinatra/base'

require 'json'

class Produce < Sinatra::Base
  _fruits = {
    1 => {
      :id => 1,
      :type => 'apple',
      :quantity => 12,
      :price => 1.25
    },
    2 => {
      :id => 2,
      :type => 'pear',
      :quantity => 10,
      :price => 1.00
    },
  }

  _purchases = {}

  get '/fruits' do
    _fruits.collect() { |k, v| v }.to_json()
  end

  get '/fruits/:id' do |id|
    _fruits[id.to_i()].to_json()
  end

  post '/fruits' do
    fruit = JSON.parse(request.body.read());
    added = {
      :id => _fruits.length() + 1,
      :type => fruit['type'],
      :quantity => fruit['quantity'],
      :price => fruit['price'],
    }
    _fruits[added[:id]] = added

    ""
  end

  put '/fruits/:id' do |id_s|
    id = id_s.to_i()
    fruit = JSON.parse(request.body.read());
    if _fruits.key? id
      updated = _fruits[id]
      updated[:type] = fruit['type']
      updated[:quantity] = fruit['quantity']
      updated[:price] = fruit['price']
    end

    ""
  end

  get '/purchases' do
    _purchases.collect() { |k, v| v }.to_json()
  end

  post '/purchases' do
    purchase = JSON.parse(request.body.read());
    if _fruits.key? purchase['fruit_id']
      added = {
        :id => _purchases.length + 1,
        :fruit_id => purchase['fruit_id'],
        :quantity => purchase['quantity'],
      }
       
      _fruits[added[:fruit_id]][:quantity] -= added[:quantity]
      _purchases[added[:id]] = added
    end

    ""
  end

  run! if app_file == $0
end
